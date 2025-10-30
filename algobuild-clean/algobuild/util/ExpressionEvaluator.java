package algobuild.util;

import algobuild.execution.ExecutionContext;

/**
 * Valutatore di espressioni per AlgoBuild.
 * Supporta operazioni aritmetiche, logiche, confronti e funzioni matematiche.
 */
public class ExpressionEvaluator {

    /**
     * Valuta un'espressione nel contesto dato.
     */
    public static Object evaluate(String expression, ExecutionContext context) throws Exception {
        if (expression == null || expression.trim().isEmpty()) {
            return null;
        }

        expression = expression.trim();

        // Controlla se è una variabile
        if (isVariable(expression)) {
            return context.getVariable(expression);
        }

        // Controlla se è un numero
        if (isNumber(expression)) {
            return parseNumber(expression);
        }

        // Controlla se è una stringa (tra virgolette)
        if (isString(expression)) {
            return expression.substring(1, expression.length() - 1);
        }

        // TODO: Implementare parser completo per espressioni
        // Per ora supportiamo solo operazioni base

        // Operazioni aritmetiche semplici
        if (expression.contains("+")) {
            String[] parts = expression.split("\\+", 2);
            Object left = evaluate(parts[0].trim(), context);
            Object right = evaluate(parts[1].trim(), context);
            return toNumber(left) + toNumber(right);
        }

        if (expression.contains("-") && !expression.startsWith("-")) {
            String[] parts = expression.split("-", 2);
            Object left = evaluate(parts[0].trim(), context);
            Object right = evaluate(parts[1].trim(), context);
            return toNumber(left) - toNumber(right);
        }

        if (expression.contains("*")) {
            String[] parts = expression.split("\\*", 2);
            Object left = evaluate(parts[0].trim(), context);
            Object right = evaluate(parts[1].trim(), context);
            return toNumber(left) * toNumber(right);
        }

        if (expression.contains("/")) {
            String[] parts = expression.split("/", 2);
            Object left = evaluate(parts[0].trim(), context);
            Object right = evaluate(parts[1].trim(), context);
            return toNumber(left) / toNumber(right);
        }

        // Confronti
        if (expression.contains("==")) {
            String[] parts = expression.split("==", 2);
            Object left = evaluate(parts[0].trim(), context);
            Object right = evaluate(parts[1].trim(), context);
            return toNumber(left) == toNumber(right);
        }

        if (expression.contains("!=")) {
            String[] parts = expression.split("!=", 2);
            Object left = evaluate(parts[0].trim(), context);
            Object right = evaluate(parts[1].trim(), context);
            return toNumber(left) != toNumber(right);
        }

        if (expression.contains("<=")) {
            String[] parts = expression.split("<=", 2);
            Object left = evaluate(parts[0].trim(), context);
            Object right = evaluate(parts[1].trim(), context);
            return toNumber(left) <= toNumber(right);
        }

        if (expression.contains(">=")) {
            String[] parts = expression.split(">=", 2);
            Object left = evaluate(parts[0].trim(), context);
            Object right = evaluate(parts[1].trim(), context);
            return toNumber(left) >= toNumber(right);
        }

        if (expression.contains("<")) {
            String[] parts = expression.split("<", 2);
            Object left = evaluate(parts[0].trim(), context);
            Object right = evaluate(parts[1].trim(), context);
            return toNumber(left) < toNumber(right);
        }

        if (expression.contains(">")) {
            String[] parts = expression.split(">", 2);
            Object left = evaluate(parts[0].trim(), context);
            Object right = evaluate(parts[1].trim(), context);
            return toNumber(left) > toNumber(right);
        }

        // Operatori logici
        if (expression.contains("&&") || expression.contains("AND")) {
            String separator = expression.contains("&&") ? "&&" : "AND";
            String[] parts = expression.split(separator, 2);
            Object left = evaluate(parts[0].trim(), context);
            Object right = evaluate(parts[1].trim(), context);
            return toBoolean(left) && toBoolean(right);
        }

        if (expression.contains("||") || expression.contains("OR")) {
            String separator = expression.contains("||") ? "\\|\\|" : "OR";
            String[] parts = expression.split(separator, 2);
            Object left = evaluate(parts[0].trim(), context);
            Object right = evaluate(parts[1].trim(), context);
            return toBoolean(left) || toBoolean(right);
        }

        // Funzioni matematiche
        if (expression.startsWith("sqrt(") && expression.endsWith(")")) {
            String arg = expression.substring(5, expression.length() - 1);
            Object value = evaluate(arg, context);
            return Math.sqrt(toNumber(value));
        }

        if (expression.startsWith("abs(") && expression.endsWith(")")) {
            String arg = expression.substring(4, expression.length() - 1);
            Object value = evaluate(arg, context);
            return Math.abs(toNumber(value));
        }

        if (expression.startsWith("sin(") && expression.endsWith(")")) {
            String arg = expression.substring(4, expression.length() - 1);
            Object value = evaluate(arg, context);
            return Math.sin(toNumber(value));
        }

        if (expression.startsWith("cos(") && expression.endsWith(")")) {
            String arg = expression.substring(4, expression.length() - 1);
            Object value = evaluate(arg, context);
            return Math.cos(toNumber(value));
        }

        throw new Exception("Espressione non valida: " + expression);
    }

    /**
     * Converte un object in double.
     */
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
            return (Boolean) obj ? 1.0 : 0.0;
        }
        return 0.0;
    }

    /**
     * Converte un object in boolean.
     */
    public static boolean toBoolean(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof Number) {
            return ((Number) obj).doubleValue() != 0.0;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            return !str.isEmpty() && !str.equalsIgnoreCase("false") && !str.equals("0");
        }
        return false;
    }

    // ========== Helper Methods ==========

    private static boolean isVariable(String str) {
        return str.matches("[a-zA-Z_][a-zA-Z0-9_]*");
    }

    private static boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static Object parseNumber(String str) {
        if (str.contains(".")) {
            return Double.parseDouble(str);
        } else {
            return Integer.parseInt(str);
        }
    }

    private static boolean isString(String str) {
        return (str.startsWith("\"") && str.endsWith("\"")) ||
               (str.startsWith("'") && str.endsWith("'"));
    }
}
