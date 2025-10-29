# Indice File AlgoBuild Refactorizzato

## Struttura Completa

```
src/
└── com/algobuild/
    ├── core/
    │   ├── application/    - Core applicazione (configurazione, gestione)
    │   └── blocks/         - Modello blocchi algoritmici (if, while, for, etc.)
    ├── editor/
    │   ├── core/           - Logica core dell'editor
    │   └── ui/             - UI componenti editor
    ├── expression/         - Parser espressioni matematiche
    ├── graphics/           - Rendering grafico blocchi
    ├── i18n/               - Internazionalizzazione (traduzioni)
    ├── io/                 - Input/Output file AlgoBuild
    ├── json/               - Libreria JSON
    ├── main/               - Finestra principale e avvio
    ├── security/           - Sistema licenze
    │   └── base/           - Classi base sicurezza
    ├── ui/                 - Interfaccia utente
    │   ├── components/     - Componenti UI custom
    │   └── dialogs/        - Finestre di dialogo (opzionale)
    └── utils/              - Utilità varie
```

## File per Package

### com.algobuild.json (6 file)
Libreria completa per parsing e manipolazione JSON.

### com.algobuild.expression (13 file)
Parser completo per espressioni matematiche con supporto per:
- Operatori aritmetici (+, -, *, /, %, ^)
- Operatori logici (&&, ||, !)
- Operatori di confronto (<, >, <=, >=, ==, !=)
- Funzioni matematiche (sin, cos, tan, sqrt, etc.)
- Gestione variabili e array

### com.algobuild.core.application
Gestione applicazione principale, configurazione UI, font scaling.

### com.algobuild.core.blocks
Tutti i tipi di blocchi algoritmici:
- Blocchi di controllo (if, while, for)
- Blocchi I/O (input, output)
- Blocchi di assegnazione
- Blocchi funzione

### com.algobuild.editor
Editor grafico per creare e modificare algoritmi.

### com.algobuild.ui
Componenti interfaccia utente dell'applicazione.

### com.algobuild.io
Gestione lettura/scrittura file .alg (formato AlgoBuild).

### com.algobuild.main
Finestra principale e bootstrap dell'applicazione.

### com.algobuild.security
Sistema di licenze e validazione (opzionale).

### com.algobuild.i18n
Sistema di localizzazione per supporto multi-lingua.

### com.algobuild.graphics
Rendering grafico dei blocchi algoritmici.

### com.algobuild.utils
Classi di utilità varie.
