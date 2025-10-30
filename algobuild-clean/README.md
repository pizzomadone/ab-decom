# AlgoBuild - Reimplementazione Pulita

## 📋 Panoramica

Questa è una **reimplementazione completa** di AlgoBuild con codice **pulito, leggibile e ben strutturato**, mantenendo **identica funzionalità** all'originale.

### 🎯 Obiettivi

- ✅ **Codice comprensibile**: Nomi di classi, metodi e variabili chiari
- ✅ **Architettura pulita**: Separazione model-view-controller
- ✅ **Rendering identico**: Forme geometriche esatte (rettangoli, rombi, parallelogrammi)
- ✅ **Funzionalità identica**: Stessa logica di esecuzione dell'originale
- ✅ **Documentazione**: Commenti e javadoc per ogni classe

---

## 📦 Struttura del Progetto

```
algobuild-clean/
├── algobuild/
│   ├── model/              # Data model
│   │   ├── Document.java           # Documento principale
│   │   ├── ViewOptions.java        # Font, colori, sizing
│   │   └── blocks/                 # 10 tipi di blocchi
│   │       ├── Block.java              # Classe base astratta
│   │       ├── AssignmentBlock.java    # x = espressione
│   │       ├── InputBlock.java         # READ variabile
│   │       ├── OutputBlock.java        # WRITE espressione
│   │       ├── IfBlock.java            # IF condizione
│   │       ├── ForBlock.java           # FOR loop
│   │       ├── WhileBlock.java         # WHILE loop
│   │       ├── DoWhileBlock.java       # DO-WHILE loop
│   │       ├── CommentBlock.java       # Commento
│   │       └── CallBlock.java          # Chiamata procedura
│   │
│   ├── view/               # Rendering visuale
│   │   └── blocks/
│   │       ├── BaseBlockPanel.java         # Base con Graphics2D
│   │       ├── RectangleBlockView.java     # Rettangoli
│   │       ├── DiamondBlockView.java       # Rombi (IF)
│   │       ├── ParallelogramBlockView.java # Parallelogrammi (I/O)
│   │       └── ConnectorView.java          # Frecce tra blocchi
│   │
│   ├── controller/         # (TODO) Gestione eventi e logica UI
│   │
│   ├── execution/          # Engine di esecuzione
│   │   └── ExecutionContext.java   # Variabili, stack, I/O
│   │
│   ├── io/                 # (TODO) Save/Load JSON
│   │
│   └── util/               # Utility
│       └── ExpressionEvaluator.java # Valutatore espressioni
│
└── AlgoBuildMain.java      # Test rendering (temporaneo)
```

---

## 🎨 Rendering Visuale

### Forme Implementate

#### 1. **Rettangolo** (Assignment, Comment, Call)
```
┌─────────────────┐
│   x = 10        │
└─────────────────┘
```
- Bordi arrotondati
- Dimensioni dinamiche dal testo
- Ombra per effetto 3D

#### 2. **Rombo** (IF Condition)
```
    ◆
   ╱ ╲
  │ x>5│
   ╲ ╱
    ◆
   T│ F
```
- 4 vertici esatti
- Condizione centrata
- Labels "T" e "F" per rami

#### 3. **Parallelogramma** (Input/Output)
```
 ╱────────────╲
│  READ x     │
╲────────────╱
```
- 6 vertici con effetto skew
- Inclinazione per distinguere I/O
- Formula esatta dall'originale

#### 4. **Connettori**
```
    │
    │
    ↓
[NEW] ← Hover per aggiungere blocco
    │
    ↓
```
- Linea verticale con freccia
- Cliccabile per inserire blocchi
- Hover effect

---

## ✨ Caratteristiche Implementate

### ✅ Completato

1. **Data Model (100%)**
   - Document con main/procedures/functions
   - ViewOptions con font metrics (unità e, f)
   - 10 tipi di blocchi con execute()
   - ExecutionContext con stack e variabili

2. **Expression Evaluator (80%)**
   - Operazioni aritmetiche (+, -, *, /)
   - Confronti (==, !=, <, >, <=, >=)
   - Operatori logici (&&, ||)
   - Funzioni math (sqrt, abs, sin, cos)
   - TODO: Parser completo con precedenza operatori

3. **Rendering Blocchi (90%)**
   - BaseBlockPanel con Graphics2D + antialiasing
   - RectangleBlockView per blocchi semplici
   - DiamondBlockView per IF (rombo 4 vertici)
   - ParallelogramBlockView per I/O (6 vertici)
   - ConnectorView per frecce
   - Stati: normale, hover, executing (con colori)

### 🔄 In Progresso

4. **Canvas Editor (0%)**
   - TODO: Layout manager per flowchart
   - TODO: Drag & drop blocchi
   - TODO: Gestione blocchi nested (loop, if)
   - TODO: Zoom e scroll

5. **Execution Engine (30%)**
   - ExecutionContext base implementato
   - TODO: Step-by-step execution
   - TODO: Breakpoints
   - TODO: Timer-based execution
   - TODO: Highlighting blocco corrente

### ⏳ Da Fare

6. **Main Window (0%)**
   - TODO: Menu bar (File, Edit, Run, Language, Author, Help)
   - TODO: Toolbar con pulsanti azioni
   - TODO: Palette blocchi con tabs
   - TODO: Console output
   - TODO: Variables panel

7. **File I/O (0%)**
   - TODO: Save/Load formato JSON
   - TODO: Export immagine
   - TODO: Import algoritmi

8. **Features Avanzate (0%)**
   - TODO: Undo/Redo
   - TODO: Copy/Paste
   - TODO: Multiple tabs per procedure/funzioni
   - TODO: Syntax highlighting
   - TODO: Auto-formatting

---

## 🚀 Come Testare

### Compilazione

```bash
cd algobuild-clean
javac algobuild/**/*.java AlgoBuildMain.java
```

### Esecuzione Test Rendering

```bash
java AlgoBuildMain
```

**Cosa vedrai:**
- Finestra con diversi blocchi:
  - Assignment: `x = 10`
  - Assignment: `y = x * 2`
  - IF: `x > 5` (rombo)
  - Input: `READ n` (parallelogramma)
  - Output: `WRITE x + y` (parallelogramma)
  - Comment: "This is a test comment"
- Hover sui blocchi per vedere highlighting
- Hover sui connettori per vedere "NEW"

---

## 📊 Stato Implementazione

| Componente | Progresso | Note |
|-----------|-----------|------|
| Data Model | ✅ 100% | Tutti i blocchi implementati |
| Expression Evaluator | 🔄 80% | Base funzionante, manca parser completo |
| Rendering Blocchi | ✅ 90% | Forme corrette, manca solo CompositeBlockView |
| Connectors | ✅ 100% | Frecce cliccabili complete |
| Canvas Editor | ⏳ 0% | Da implementare |
| Execution Engine | 🔄 30% | Base pronto, manca step-by-step |
| Main Window | ⏳ 0% | Da implementare |
| File I/O | ⏳ 0% | Da implementare |
| **TOTALE** | **🔄 50%** | **Metà del lavoro completata** |

---

## 🎯 Prossimi Passi

### Priorità Alta
1. **Canvas Editor** - Sistema layout per flowchart
2. **Execution Engine** - Step-by-step con highlighting
3. **Main Window** - GUI completa con menu/toolbar

### Priorità Media
4. **CompositeBlockView** - Rendering loop/if con body annidato
5. **File I/O** - Save/Load JSON
6. **Palette Blocchi** - Drag & drop da palette

### Priorità Bassa
7. **Features Avanzate** - Undo/Redo, Copy/Paste
8. **Ottimizzazioni** - Performance, memory
9. **Testing** - Unit tests, integration tests

---

## 📝 Differenze con l'Originale

### Miglioramenti
- ✅ **Nomi chiari**: `AssignmentBlock` invece di `a.c.b.a`
- ✅ **Commenti**: Ogni classe documentata
- ✅ **Struttura MVC**: Separazione model-view-controller
- ✅ **Codice leggibile**: Indent, spacing, convenzioni Java

### Identico all'Originale
- ✅ **Forme geometriche**: Formule esatte da IMPLEMENTATION_DETAILS.md
- ✅ **Font metrics**: Sistema unità e, f identico
- ✅ **Colori e stati**: Normale, hover, executing
- ✅ **Logica blocchi**: Execute() identico all'originale

---

## 🔬 Analisi Tecnica

### Font Metrics System
```java
// Formula originale: e = f = (fontHeight + 1) / 2
int e = (font.getSize() + 1) / 2;  // Width unit
int f = (font.getSize() + 1) / 2;  // Height unit
```

### Block Shapes
```java
// Rectangle
graphics.fillRoundRect(x, y, width, height, 10, 10);

// Diamond (4 vertices)
int[] xPoints = {centerX, centerX + halfWidth, centerX, centerX - halfWidth};
int[] yPoints = {centerY - halfHeight, centerY, centerY + halfHeight, centerY};
graphics.fillPolygon(xPoints, yPoints, 4);

// Parallelogram (6 vertices)
// Con offset per effetto skew
```

### Color States
```java
// Normale
backgroundColor = viewOptions.getNormalBackground();
borderColor = viewOptions.getNormalBorder();

// Hover
backgroundColor = viewOptions.getHoverBackground();
borderColor = viewOptions.getHoverBorder();

// Executing
backgroundColor = viewOptions.getExecutingBackground();
borderColor = viewOptions.getExecutingBorder();
```

---

## 📚 Riferimenti

- **Analisi Originale**: `../ARCHITECTURE_ANALYSIS.md`
- **Implementation Details**: `../IMPLEMENTATION_DETAILS.md`
- **Class Mapping**: `../CLASS_MAPPING_GUIDE.md`
- **Summary**: `../ANALYSIS_SUMMARY.md`

---

## 🤝 Contributori

Reimplementazione basata su analisi completa del codice decompilato AlgoBuild originale.

**Obiettivo**: Codice identico nella funzionalità, 100% più leggibile nella forma.

---

## 📄 Licenza

Questo è un progetto di refactoring educativo per migliorare la leggibilità del codice mantenendo la funzionalità originale di AlgoBuild.

---

**Stato**: 🔄 **In Sviluppo Attivo** - 50% completato

**Ultima modifica**: 2025-01-XX
