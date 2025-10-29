# AlgoBuild - Progetto Decompilato e Refactorizzato

## Panoramica

Questo progetto contiene il codice decompilato di **AlgoBuild 0.85**, un'applicazione educativa per la creazione e visualizzazione di algoritmi, completamente refactorizzato per migliorare la leggibilità.

## Problema Originale

Il codice decompilato era completamente **illeggibile**:
```
├── a/
│   ├── a/
│   │   ├── a.java
│   │   ├── b.java
│   │   └── c.java
│   ├── b/
│   └── c/
├── b/
│   └── a/
└── c/
```

Tutti i package si chiamavano `a`, `b`, `c` e tutte le classi `a.java`, `b.java`, `c.java`.

## Soluzione: Struttura Refactorizzata

Il codice è stato riorganizzato in una struttura **leggibile e comprensibile**:

```
src/com/algobuild/
├── core/
│   ├── application/    ✓ Gestione applicazione e configurazione
│   └── blocks/         ✓ Modello blocchi algoritmici (if, while, for...)
├── editor/
│   ├── core/           ✓ Logica dell'editor di algoritmi
│   └── ui/             ✓ Interfaccia grafica editor
├── expression/         ✓ Parser espressioni matematiche completo
├── graphics/           ✓ Rendering grafico dei blocchi
├── i18n/               ✓ Internazionalizzazione (IT/EN)
├── io/                 ✓ Gestione file .alg
├── json/               ✓ Libreria JSON completa
├── main/               ✓ Finestra principale
├── security/           ✓ Sistema licenze
│   └── base/
├── ui/                 ✓ Componenti UI
│   └── components/
└── utils/              ✓ Utilità varie
```

## Statistiche

- **169 file Java** refactorizzati
- **20 package** ben organizzati
- **Mappatura completa** da vecchia a nuova struttura

## Documentazione

1. **[README_REFACTORED.md](README_REFACTORED.md)** - Guida completa al refactoring
   - Mappatura completa package originali → nuovi
   - Mappatura classi principali
   - Come navigare il codice

2. **[src/FILE_INDEX.md](src/FILE_INDEX.md)** - Indice file e struttura
   - Elenco completo package
   - Descrizione di ogni componente

3. **[refactor_plan.md](refactor_plan.md)** - Piano di refactoring originale

## Cosa è Stato Cambiato

### ✅ Migliorato
- **Package names**: Da `a`, `b`, `c` → `com.algobuild.{json, expression, core, ...}`
- **Struttura directory**: Organizzata per funzionalità
- **Documentazione**: README e commenti aggiunti
- **Navigabilità**: Facile capire dove si trova ogni componente

### 📝 Mantenuto Originale
- **Nomi metodi/variabili**: I nomi interni (`a()`, `b()`, `variabile_c`) sono mantenuti dal decompilato
- **Logica**: Tutta la logica originale è preservata identica
- **Funzionalità**: Il codice fa esattamente le stesse cose

## Come Usare Questo Codice

### Navigazione Rapida

1. **Entry point**: `src/com/algobuild/main/AlgoBuildBootLoader.java`
2. **App principale**: `src/com/algobuild/core/application/Application.java`
3. **Blocchi algoritmi**: `src/com/algobuild/core/blocks/`
4. **Editor**: `src/com/algobuild/editor/`
5. **Parser espressioni**: `src/com/algobuild/expression/ExpressionParser.java`

### Esempio: Trovare la Gestione File

**Prima** (illeggibile):
```
a/f/a.java  ← Che cos'è?? Impossibile capirlo
```

**Adesso** (leggibile):
```
src/com/algobuild/io/AlgoBuildFileInputStream.java  ← Chiaro!
```

## Componenti Principali

### 📦 JSON Library (`com.algobuild.json`)
Libreria completa per parsing JSON:
- `JSONArray`, `JSONObject`
- `JSONTokenizer` per parsing
- Gestione tipi e eccezioni

### 🧮 Expression Parser (`com.algobuild.expression`)
Parser completo di espressioni con:
- Operatori aritmetici, logici, bitwise
- Funzioni matematiche (sin, cos, sqrt, ...)
- Variabili e array
- Conversioni tipo

### 🎨 Core Application (`com.algobuild.core`)
- **application/**: Configurazione app, UI scaling, look&feel
- **blocks/**: Tutti i blocchi (If, While, For, Input, Output, ...)

### ✏️ Editor (`com.algobuild.editor`)
Editor grafico per creare algoritmi visualmente.

### 💾 File I/O (`com.algobuild.io`)
Gestione formato file `.alg` proprietario di AlgoBuild.

## Prossimi Passi (Opzionali)

Per migliorare ulteriormente la leggibilità:

1. **Rinominare metodi**: Da `a()` → `calculate()`, `b()` → `validate()`, etc.
2. **Javadoc**: Aggiungere documentazione ai metodi pubblici
3. **Variabili**: Da `int a` → `int blockCount`, etc.
4. **Costanti**: Estrarre numeri "magici" in costanti nominate
5. **Commenti**: Spiegare logica complessa

## Note Tecniche

- **Decompiler**: CFR 0.152
- **Versione**: AlgoBuild 0.85
- **Formato**: Java (compatibile Java 8+)

## Struttura File Originali

I file originali sono mantenuti nelle directory `a/`, `b/`, `c/` per riferimento.
La nuova struttura refactorizzata è in `src/`.

## Licenza

Questo è codice decompilato di AlgoBuild per scopi educativi e di studio.
Tutti i diritti appartengono agli autori originali di AlgoBuild.

---

**Refactoring completato il**: 29 Ottobre 2025
**Obiettivo raggiunto**: ✅ Codice ora leggibile e navigabile!
