# Piano di Refactoring AlgoBuild Decompilato

## Mappatura Package

### Package Originali → Nuovi

| Originale | Nuovo | Descrizione |
|-----------|-------|-------------|
| `b.a` | `com.algobuild.json` | Libreria JSON (7 file) |
| `c` | `com.algobuild.expression` | Parser espressioni (13 file) |
| `a.a` | `com.algobuild.ui.dialogs` | Dialoghi UI (14 file) |
| `a.b` | `com.algobuild.ui.components` | Componenti UI (4 file) |
| `a.c.a` | `com.algobuild.core.application` | Core applicazione |
| `a.c.b` | `com.algobuild.core.model` | Modello dati blocchi |
| `a.d` | `com.algobuild.security` | Sistema licenze (7 file) |
| `a.e` | `com.algobuild.security.base` | Base security |
| `a.f` | `com.algobuild.io` | File I/O (12 file) |
| `a.g` | `com.algobuild.graphics` | Graphics/Drawing |
| `a.h` | `com.algobuild.utils` | Utilities |
| `a.i` | `com.algobuild.i18n` | Internazionalizzazione |
| `a.j` | `com.algobuild.editor` | Editor components |
| `a.k` | `com.algobuild.main` | Main window & app |

### Classi JSON (b.a)
- `a.java` → `JSONArray.java`
- `b.java` → `JSONException.java`
- `c.java` → `JSONObject.java`
- `d.java` → `JSONNull.java`
- `e.java` → `JSONString.java`
- `f.java` → `JSONTokenizer.java`

### Classi Expression (c)
- `a.java` → `ExpressionParser.java`
- `b.java` → `OperatorType.java`
- `c.java` → `TokenType.java`
- `g.java` → `ExpressionException.java`
- `h.java` → `BooleanValue.java`
- `i.java` → `DoubleValue.java`
- `j.java` → `IntegerValue.java`
- `k.java` → `StringValue.java`
- `l.java` → `Value.java` (base interface)
- `m.java` → `Variable.java`

### Classi principali Core (a.c.a)
- `a.java` → `Application.java`
- `b.java` → `Settings.java`
- Altri TBD dopo analisi

## Strategia di Refactoring
1. Creare nuova struttura package
2. Copiare file package per package
3. Rinominare classi con nomi significativi
4. Aggiornare import statements
5. Rinominare metodi/variabili critici
6. Aggiungere javadoc
