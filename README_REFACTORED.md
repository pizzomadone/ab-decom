# AlgoBuild - Progetto Refactorizzato per Leggibilità

Questo è il progetto AlgoBuild decompilato e riorganizzato per essere leggibile.

## Struttura Originale vs Nuova

### Cambiamenti Principali

**Prima**:
- Package: `a`, `b`, `c`
- Classi: `a.java`, `b.java`, `c.java`
- Metodi: `a()`, `b()`, `c()`

**Dopo**:
- Package: `com.algobuild.{json, expression, ui, core, io, main}`
- Classi: Nomi descrittivi (JSONArray, ExpressionParser, etc.)
- Metodi: Mantenuti i nomi originali decompilati (documentati dove necessario)

## Mappatura Complete dei Package

| Package Originale | Package Nuovo | Descrizione |
|-------------------|---------------|-------------|
| `b.a` | `com.algobuild.json` | Libreria JSON per serializzazione/parsing |
| `c` | `com.algobuild.expression` | Parser e evaluatore di espressioni matematiche |
| `a.a` | `com.algobuild.ui.dialogs` | Finestre di dialogo dell'interfaccia utente |
| `a.b` | `com.algobuild.ui.components` | Componenti UI personalizzati |
| `a.c.a` | `com.algobuild.core.application` | Core applicazione e configurazione |
| `a.c.b` | `com.algobuild.core.blocks` | Modello dei blocchi algoritmici |
| `a.d` | `com.algobuild.security` | Sistema di licenze e sicurezza |
| `a.e` | `com.algobuild.security.base` | Classi base per sicurezza |
| `a.f` | `com.algobuild.io` | Input/Output e gestione file |
| `a.g` | `com.algobuild.graphics` | Rendering grafico dei blocchi |
| `a.h` | `com.algobuild.utils` | Utilità varie |
| `a.i` | `com.algobuild.i18n` | Internazionalizzazione e traduzioni |
| `a.j` | `com.algobuild.editor` | Editor di algoritmi |
| `a.k` | `com.algobuild.main` | Finestra principale e avvio |

## Mappatura Classi Principali

### Package JSON (`com.algobuild.json`)
- `JSONArray.java` ← `b/a/a.java` - Array JSON
- `JSONException.java` ← `b/a/b.java` - Eccezioni JSON
- `JSONObject.java` ← `b/a/c.java` - Oggetto JSON
- `JSONNull.java` ← `b/a/d.java` - Valore null JSON
- `JSONString.java` ← `b/a/e.java` - Interfaccia stringa JSON
- `JSONTokenizer.java` ← `b/a/f.java` - Tokenizer per parsing JSON

### Package Expression (`com.algobuild.expression`)
- `ExpressionParser.java` ← `c/a.java` - Parser di espressioni
- `OperatorType.java` ← `c/b.java` - Enum tipi di operatori
- `TokenType.java` ← `c/c.java` - Enum tipi di token
- `ExpressionException.java` ← `c/g.java` - Eccezioni parser
- `BooleanValue.java` ← `c/h.java` - Valore booleano
- `DoubleValue.java` ← `c/i.java` - Valore double
- `IntegerValue.java` ← `c/j.java` - Valore intero
- `StringValue.java` ← `c/k.java` - Valore stringa
- `Value.java` ← `c/l.java` - Interfaccia valore base
- `Variable.java` ← `c/m.java` - Variabile

### Package UI (`com.algobuild.ui`)
- `AssignDialog.java` ← `a/a/a.java` - Dialogo di assegnazione

### Package Core (`com.algobuild.core`)
- `Application.java` ← `a/c/a/a.java` - Classe applicazione principale

### Package IO (`com.algobuild.io`)
- `AlgoBuildFileInputStream.java` ← `a/f/a.java` - Stream di input file

### Main (`com.algobuild.main`)
- `AlgoBuildBootLoader.java` ← `AlgoBuildBootLoader.java` - Bootloader

## Note Importanti

1. **Nomi Interni**: I nomi di metodi e variabili all'interno delle classi mantengono i nomi originali decompilati (`a()`, `b()`, `c`, `d`, etc.). Questo è normale per codice decompilato.

2. **Struttura Leggibile**: La nuova struttura dei package e i nomi delle classi rendono molto più facile capire l'organizzazione del progetto.

3. **Documentazione**: Header commentati sono stati aggiunti ai file principali per indicare la loro provenienza originale.

4. **Compilazione**: I file potrebbero richiedere aggiustamenti agli import per compilare correttamente.

## Come Navigare il Codice

1. Inizia da `com.algobuild.main.AlgoBuildBootLoader` - punto di ingresso
2. Guarda `com.algobuild.core.Application` - logica principale
3. I blocchi algoritmici sono in `com.algobuild.core.blocks`
4. L'editor è in `com.algobuild.editor`
5. L'UI è distribuita tra `com.algobuild.ui.*`

## Prossimi Passi per Migliorare la Leggibilità

1. Rinominare metodi critici con nomi descrittivi
2. Aggiungere javadoc ai metodi pubblici
3. Rinominare variabili importanti
4. Estrarre costanti "magiche" in variabili nominate
5. Aggiungere commenti esplicativi alla logica complessa
