# AlgoBuild - Riscrittura Completa

## Obiettivo
Riscrivere AlgoBuild completamente con:
- ✅ Codice pulito e leggibile
- ✅ Nomi descrittivi e comprensibili
- ✅ Architettura semplificata
- ✅ Stesso comportamento dell'originale
- ✅ Molto meno classi

## Architettura Semplificata

### Componenti Core (8-10 classi principali)

1. **Model** (Modello dei dati)
   - `Algorithm` - Rappresenta un algoritmo completo
   - `Block` - Classe base per tutti i blocchi
   - `IfBlock`, `WhileBlock`, `ForBlock`, `AssignBlock`, etc.
   - `Variable` - Gestione variabili

2. **Parser** (Valutazione espressioni)
   - `ExpressionEvaluator` - Parser ed evaluatore di espressioni

3. **Executor** (Esecuzione algoritmi)
   - `AlgorithmExecutor` - Esegue step-by-step gli algoritmi

4. **Editor** (UI grafica)
   - `AlgorithmEditor` - Editor visuale drag-drop
   - `BlockRenderer` - Rendering grafico blocchi

5. **Persistence** (Salvataggio/caricamento)
   - `AlgorithmSerializer` - Salva/carica file .alg

6. **UI** (Interfaccia)
   - `AlgoBuildApp` - Finestra principale
   - `ExecutionPanel` - Pannello esecuzione

## Confronto

**Originale**: 170 file, package incomprensibili
**Riscrittura**: ~15-20 file, tutto comprensibile

## Struttura File

```
rewritten/algobuild/
├── model/
│   ├── Algorithm.java
│   ├── Block.java
│   ├── IfBlock.java
│   ├── WhileBlock.java
│   └── Variable.java
├── parser/
│   └── ExpressionEvaluator.java
├── executor/
│   └── AlgorithmExecutor.java
├── editor/
│   ├── AlgorithmEditor.java
│   └── BlockRenderer.java
├── io/
│   └── AlgorithmSerializer.java
└── ui/
    └── AlgoBuildApp.java
```
