package algobuild.parser;

import algobuild.model.ExecutionContext;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Valutatore di espressioni matematiche e logiche.
 * Supporta:
 * - Aritmetica: +, -, *, /, %, ^
 * - Confronto: ==, !=, <, >, <=, >=
 * - Logica: &&, ||, !
 * - Funzioni: sin, cos, sqrt, abs, etc.
 * - Variabili e stringhe
 */
public class ExpressionEvaluator {

    /**
     * Valuta un'espressione e ritorna il risultato
     */
    public static Object evaluate(String expression, ExecutionContext context) throws Exception {
        expression = expression.trim();

        // Stringhe letterali
        if (expression.startsWith("\"") && expression.endsWith("\"")) {
            return expression.substring(1, expression.length() - 1);
        }

        // Numeri letterali
        if (isNumber(expression)) {
            return parseNumber(expression);
        }

        // Variabili
        if (isVariable(expression) && context.hasVariable(expression)) {
            return context.getVariable(expression);
        }

        // Operatori logici
        if (expression.contains("&&") || expression.contains("||")) {
            return evaluateLogical(expression, context);
        }

        // Operatori di confronto
        if (containsComparison(expression)) {
            return evaluateComparison(expression, context);
        }

        // Operatori aritmetici
        return evaluateArithmetic(expression, context);
    }

    /**
     * Valuta espressione logica (&&, ||, !)
     */
    private static Object evaluateLogical(String expr, ExecutionContext context) throws Exception {
        // OR ha precedenza più bassa
        if (expr.contains("||")) {
            String[] parts = splitByOperator(expr, "||");
            boolean result = false;
            for (String part : parts) {
                if (toBoolean(evaluate(part.trim(), context))) {
                    result = true;
                    break;
                }
            }
            return result;
        }

        // AND
        if (expr.contains("&&")) {
            String[] parts = splitByOperator(expr, "&&");
            boolean result = true;
            for (String part : parts) {
                if (!toBoolean(evaluate(part.trim(), context))) {
                    result = false;
                    break;
                }
            }
            return result;
        }

        // NOT
        if (expr.trim().startsWith("!")) {
            return !toBoolean(evaluate(expr.substring(1).trim(), context));
        }

        return toBoolean(evaluate(expr, context));
    }

    /**
     * Valuta espressione di confronto (==, !=, <, >, <=, >=)
     */
    private static Object evaluateComparison(String expr, ExecutionContext context) throws Exception {
        String[][] operators = {{"=="}, {"!="}, {"<="}, {">="}, {"<"}, {">"}};

        for (String[] ops : operators) {
            for (String op : ops) {
                if (expr.contains(op)) {
                    String[] parts = splitByOperator(expr, op);
                    if (parts.length == 2) {
                        Object left = evaluate(parts[0].trim(), context);
                        Object right = evaluate(parts[1].trim(), context);
                        return compare(left, right, op);
                    }
                }
            }
        }

        return toBoolean(evaluate(expr, context));
    }

    /**
     * Valuta espressione aritmetica (+, -, *, /, %, ^)
     */
    private static Object evaluateArithmetic(String expr, ExecutionContext context) throws Exception {
        expr = expr.trim();

        // Rimuovi parentesi esterne se presenti
        if (expr.startsWith("(") && expr.endsWith(")")) {
            expr = expr.substring(1, expr.length() - 1).trim();
        }

        // Somma e sottrazione (precedenza più bassa)
        for (int i = expr.length() - 1; i >= 0; i--) {
            char c = expr.charAt(i);
            if ((c == '+' || c == '-') && !isInsideParentheses(expr, i)) {
                String left = expr.substring(0, i).trim();
                String right = expr.substring(i + 1).trim();

                if (!left.isEmpty()) {
                    Object leftVal = evaluate(left, context);
                    Object rightVal = evaluate(right, context);

                    if (c == '+') {
                        return add(leftVal, rightVal);
                    } else {
                        return subtract(leftVal, rightVal);
                    }
                }
            }
        }

        // Moltiplicazione, divisione, modulo
        for (int i = expr.length() - 1; i >= 0; i--) {
            char c = expr.charAt(i);
            if ((c == '*' || c == '/' || c == '%') && !isInsideParentheses(expr, i)) {
                String left = expr.substring(0, i).trim();
                String right = expr.substring(i + 1).trim();

                Object leftVal = evaluate(left, context);
                Object rightVal = evaluate(right, context);

                if (c == '*') {
                    return multiply(leftVal, rightVal);
                } else if (c == '/') {
                    return divide(leftVal, rightVal);
                } else {
                    return modulo(leftVal, rightVal);
                }
            }
        }

        // Potenza
        if (expr.contains("^")) {
            String[] parts = expr.split("\\^", 2);
            Object base = evaluate(parts[0].trim(), context);
            Object exp = evaluate(parts[1].trim(), context);
            return Math.pow(toNumber(base), toNumber(exp));
        }

        // Funzioni matematiche
        if (expr.contains("(") && !expr.startsWith("(")) {
            return evaluateFunction(expr, context);
        }

        // Variabile o numero
        if (context.hasVariable(expr)) {
            return context.getVariable(expr);
        }

        return parseNumber(expr);
    }

    /**
     * Valuta funzione matematica
     */
    private static Object evaluateFunction(String expr, ExecutionContext context) throws Exception {
        int parenIndex = expr.indexOf('(');
        String funcName = expr.substring(0, parenIndex).trim().toLowerCase();
        String args = expr.substring(parenIndex + 1, expr.lastIndexOf(')')).trim();

        Object argValue = evaluate(args, context);
        double num = toNumber(argValue);

        switch (funcName) {
            case "sin": return Math.sin(num);
            case "cos": return Math.cos(num);
            case "tan": return Math.tan(num);
            case "sqrt": return Math.sqrt(num);
            case "abs": return Math.abs(num);
            case "floor": return Math.floor(num);
            case "ceil": return Math.ceil(num);
            case "round": return Math.round(num);
            case "ln": return Math.log(num);
            case "log": return Math.log10(num);
            case "exp": return Math.exp(num);
            default:
                throw new Exception("Unknown function: " + funcName);
        }
    }

    // ========== Operazioni aritmetiche ==========

    private static Object add(Object a, Object b) {
        if (a instanceof String || b instanceof String) {
            return String.valueOf(a) + String.valueOf(b);
        }
        return toNumber(a) + toNumber(b);
    }

    private static Object subtract(Object a, Object b) {
        return toNumber(a) - toNumber(b);
    }

    private static Object multiply(Object a, Object b) {
        return toNumber(a) * toNumber(b);
    }

    private static Object divide(Object a, Object b) {
        return toNumber(a) / toNumber(b);
    }

    private static Object modulo(Object a, Object b) {
        return toNumber(a) % toNumber(b);
    }

    // ========== Operazioni di confronto ==========

    private static boolean compare(Object a, Object b, String op) {
        if (a instanceof String || b instanceof String) {
            String sa = String.valueOf(a);
            String sb = String.valueOf(b);
            switch (op) {
                case "==": return sa.equals(sb);
                case "!=": return !sa.equals(sb);
                default: return false;
            }
        }

        double na = toNumber(a);
        double nb = toNumber(b);

        switch (op) {
            case "==": return na == nb;
            case "!=": return na != nb;
            case "<": return na < nb;
            case ">": return na > nb;
            case "<=": return na <= nb;
            case ">=": return na >= nb;
            default: return false;
        }
    }

    // ========== Utility ==========

    public static double toNumber(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).doubleValue();
        }
        if (obj instanceof String) {
            try {
                return Double.parseDouble((String) obj);
            } catch (NumberFormatException e) {
                return 0.0;
            }
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj) ? 1.0 : 0.0;
        }
        return 0.0;
    }

    public static boolean toBoolean(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof Number) {
            return ((Number) obj).doubleValue() != 0.0;
        }
        if (obj instanceof String) {
            String s = ((String) obj).toLowerCase();
            return !s.isEmpty() && !s.equals("false") && !s.equals("0");
        }
        return false;
    }

    private static boolean isNumber(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static Object parseNumber(String s) {
        if (s.contains(".")) {
            return Double.parseDouble(s);
        }
        return Integer.parseInt(s);
    }

    private static boolean isVariable(String s) {
        return s.matches("[a-zA-Z_][a-zA-Z0-9_]*");
    }

    private static boolean containsComparison(String expr) {
        return expr.contains("==") || expr.contains("!=") ||
               expr.contains("<=") || expr.contains(">=") ||
               expr.contains("<") || expr.contains(">");
    }

    private static String[] splitByOperator(String expr, String op) {
        return expr.split(Pattern.quote(op), 2);
    }

    private static boolean isInsideParentheses(String expr, int index) {
        int depth = 0;
        for (int i = 0; i < index; i++) {
            if (expr.charAt(i) == '(') depth++;
            if (expr.charAt(i) == ')') depth--;
        }
        return depth > 0;
    }
}
