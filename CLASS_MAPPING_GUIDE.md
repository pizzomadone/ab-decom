# AlgoBuild Class Mapping Guide

## Quick Reference - Obfuscated to Functional Names

### Startup and Main Window
```
AlgoBuildBootLoader.java          → Application entry point
a.c.a.a                           → Startup and initialization manager
a.k.B                             → Main startup task (Runnable)
a.k.c                             → Main window controller (Singleton)
a.k.c_0                           → Main JFrame implementation
```

### Document and Data Model
```
a.c.a.b                           → Document/Algorithm model (central)
a.c.a.d                           → Base Instruction interface
a.c.a.c                           → Execution context/stack frame
a.c.a.e                           → Algorithm executor/interpreter
a.c.a.f                           → File loader
a.c.a.g                           → Save history tracker
a.c.a.i                           → View options/styling
```

### Block Type Hierarchy
```
a.c.b.n                           → Base instruction class (parent)
a.c.b.a                           → Assignment/Simple statement
a.c.b.c                           → Function call
a.c.b.d                           → Comment block
a.c.b.e                           → Do-While loop
a.c.b.f                           → For loop
a.c.b.g                           → While loop
a.c.b.i                           → Input (READ)
a.c.b.j                           → Output (WRITE)
a.c.b.l                           → If condition
a.c.b.q                           → Procedure/Function/Main
```

### Drawing and Rendering
```
a.j.b.n                           → Base drawing panel (Graphics2D setup)
a.j.b.o                           → Instruction panel (shape container)
a.j.b.a                           → Rectangle shape renderer
a.j.b.e                           → Nested block container
a.j.b.f                           → Connector/Arrow (block connector)
a.j.b.h                           → Parallelogram (I/O block)
a.j.b.j                           → Diamond (IF condition)
a.j.b.k                           → Call block renderer
a.j.b.c_0                         → Procedure/Function container
a.j.b.b_0                         → Function call renderer
```

### UI and Editor
```
a.j.a.g                           → Main editor panel (central UI)
a.j.a.a                           → Block palette/code tab manager
a.j.a.c                           → Output console
a.j.a.h                           → Console output viewer
```

### File I/O and Persistence
```
a.f.f                             → File handler (save/load)
a.f.g                             → Object serialization
a.f.k                             → Configuration manager
a.f.j                             → Directory/path utilities
```

### Undo/Redo System
```
a.g.g                             → Base undoable operation
a.g.a                             → Block addition operation
a.g.b                             → Block deletion operation
a.g.c                             → Block modification
a.g.d                             → Block movement
a.g.e                             → Execution-related operation
a.g.f                             → Multi-step operation
```

### Localization and Resources
```
a.i.c                             → Text resource manager (strings)
a.i.b                             → Image resource loader
a.i.a                             → Image container
a.i.d                             → Dialog helper
a.i.e                             → Resource utilities
```

### Actions and Event Handlers
```
a.k.d - a.k.z                     → Various menu action handlers
a.k.a_0                           → Action manager
```

### Utilities and Helpers
```
a.a.a - a.a.n                     → Operation and dialog helpers
a.c.b.p                           → Version/build info
a.c.b.s, t, r                     → Exception types
```

---

## File Locations Quick Reference

### Core Model Files
- `/home/user/ab-decom/a/c/a/b.java` - Document model
- `/home/user/ab-decom/a/c/a/d.java` - Instruction interface
- `/home/user/ab-decom/a/c/a/e.java` - Executor

### Block Type Files
- `/home/user/ab-decom/a/c/b/` - All block type classes (a.java, c.java, d.java, etc.)

### Drawing Files
- `/home/user/ab-decom/a/j/b/a.java` - Rectangle shape
- `/home/user/ab-decom/a/j/b/j.java` - Diamond shape
- `/home/user/ab-decom/a/j/b/h.java` - Parallelogram shape
- `/home/user/ab-decom/a/j/b/f.java` - Connector/Arrow
- `/home/user/ab-decom/a/j/b/e.java` - Nested container
- `/home/user/ab-decom/a/j/b/n.java` - Base drawing panel
- `/home/user/ab-decom/a/j/b/o.java` - Instruction panel

### UI Files
- `/home/user/ab-decom/a/j/a/g.java` - Main editor panel
- `/home/user/ab-decom/a/j/a/a.java` - Block palette
- `/home/user/ab-decom/a/j/a/c.java` - Output console
- `/home/user/ab-decom/a/k/c.java` - Main window

---

## Key File Reading Order for Understanding

### For Complete Architecture Understanding:
1. `/home/user/ab-decom/AlgoBuildBootLoader.java` - Entry point
2. `/home/user/ab-decom/a/c/a/a.java` - Startup
3. `/home/user/ab-decom/a/k/c.java` - Main window
4. `/home/user/ab-decom/a/j/a/g.java` - Editor panel
5. `/home/user/ab-decom/a/c/a/b.java` - Document model
6. `/home/user/ab-decom/a/j/b/f.java` - Connector implementation
7. `/home/user/ab-decom/a/j/b/a.java` - Rectangle shape (example)
8. `/home/user/ab-decom/a/j/b/j.java` - Diamond shape (IF block)
9. `/home/user/ab-decom/a/c/a/e.java` - Executor

### For Drawing Implementation:
1. `/home/user/ab-decom/a/j/b/n.java` - Base panel setup
2. `/home/user/ab-decom/a/j/b/o.java` - Instruction rendering
3. `/home/user/ab-decom/a/j/b/a.java` - Rectangle
4. `/home/user/ab-decom/a/j/b/j.java` - Diamond
5. `/home/user/ab-decom/a/j/b/h.java` - Parallelogram

### For Execution Engine:
1. `/home/user/ab-decom/a/c/a/e.java` - Executor
2. `/home/user/ab-decom/a/c/a/c.java` - Context
3. `/home/user/ab-decom/a/c/b/n.java` - Block base class
4. `/home/user/ab-decom/a/c/b/a.java` - Assignment execution

---

## Method Naming Patterns

### Common Method Names (Obfuscated):
```
a()              → Primary action or getter (context-dependent)
b()              → Secondary action or description
c()              → Tertiary action or path/context
d()              → Further action or dialogue/delete
e()              → Even further action or element
f() - n()        → Various specialized methods
```

### Example from a.j.b.a (Rectangle):
```
a(Graphics)      → Draw/paint the shape
a()              → Recalculate dimensions
```

### Example from a.c.a.b (Document):
```
a()              → Get current context
b()              → Clear document
a(String, int)   → Create new code block
j(String)        → Save to file
k(String)        → Load from file
```

---

## Critical Class Relationships

### Document Flow
```
a.c.a.b (Document)
    ├── Contains multiple a.c.b.q (Procedures)
    │   └── Each contains a.c.b.n (Instructions)
    ├── Managed by a.j.a.g (Editor)
    ├── Saved by a.f.f (File I/O)
    └── Executed by a.c.a.e (Executor)
```

### Drawing Flow
```
a.j.a.g (Main Editor)
    ├── Contains a.j.a.a (Palette)
    ├── Contains a.j.b.e (Canvas Container)
    │   └── Contains a.j.b.c_0 (Procedure Container)
    │       └── Contains a.j.b.e (Nested Instructions)
    │           ├── a.j.b.a (Rectangle)
    │           ├── a.j.b.j (Diamond)
    │           ├── a.j.b.h (Parallelogram)
    │           └── a.j.b.f (Connector)
    └── Contains a.j.a.c (Console)
```

### Execution Flow
```
User clicks "Execute"
    ↓
a.j.a.g.h()
    ↓
a.c.a.e.a(String)  [Start]
    ↓
Timer fires every N ms
    ↓
a.c.a.e.c()        [Step]
    ↓
a.c.a.c.a()        [Execute current instruction]
    ↓
a.c.b.n.a(Document, index)  [Block-specific execution]
    ↓
Returns next index or -1 (end)
    ↓
UI highlights current block
    ↓
Repeat until end or pause
```

---

## Package Organization

### a.a.* - Operation Helpers
- Help dialogs and block operation implementations
- 15+ classes (a through n)

### a.c.* - Core Model
- a.c.a.* - Document, execution, interfaces
- a.c.b.* - Block type implementations

### a.f.* - File and Configuration
- File I/O, serialization, resources

### a.g.* - Undo/Redo
- Undoable operations

### a.i.* - Localization and Resources
- Text, images, dialogs

### a.j.a.* - UI Panels
- Editor panels, palette, console

### a.j.b.* - Drawing
- Shape rendering, connectors

### a.k.* - Main Window
- Main frame, actions, initialization

---

## Important Numbers and Constants

### Dimension Units
```
e = font height / 2       (Width unit)
f = font height / 2       (Height unit)
```

### Shape Dimensions
```
Rectangle: width = e * (2 + multiplier), height = f * (count + 1) * 2
Diamond: width = n * 2, height = f * (count + 1) * 2
Parallelogram: varies based on I/O text
```

### Timing
```
Default execution timer: 1000ms
Configurable via ViewOptions
User can set different delays per execution
```

### Colors (stored in a.c.a.i)
```
q().e()  - Normal background
q().f()  - Execution highlight background
q().g()  - Hover background
q().i()  - Normal border
q().j()  - Execution highlight border
q().k()  - Hover border
```

---

## Essential Algorithms to Implement

### 1. Block Layout (Font Metrics Based)
```
For each line of text:
  - Get string bounds using FontMetrics
  - Calculate width and height
  - Track maximum width
  - Accumulate total height
Calculate final block dimensions
Position child blocks/connectors accordingly
```

### 2. Nested Rendering (Recursive)
```
def render(block, graphics):
    if block is simple shape:
        draw rectangle/diamond/parallelogram
        draw text centered
    else if block is composite:
        draw container
        for each child:
            render(child, graphics)
        draw connectors between children
    draw connector to next block
```

### 3. Block Path Notation
```
"main" - main procedure
"main.0" - first instruction in main
"main.0.1" - second instruction in first instruction
"procName.0" - structure applies to any procedure
```

### 4. Execution Stack
```
Stack of ExecutionContext objects
Each contains:
  - Current instruction
  - Current position in instruction sequence
  - Local variables
Call stack for procedure calls
```

### 5. Shape Drawing with Graphics2D
```
Set antialiasing RenderingHint
Set stroke for borders
Fill shape with background color
Draw shape outline with border color
Draw text with proper alignment
```

---

## Debugging Tips

### Finding Block Rendering
- Search for `graphics.fillRect`, `graphics.fillPolygon`
- Look in `/home/user/ab-decom/a/j/b/` files
- Each shape type has its own class

### Finding Execution Logic
- Search for `.a(Document, index)` method
- Look in `/home/user/ab-decom/a/c/b/` files
- Returns next instruction index or -1

### Finding Event Handling
- Search for `actionPerformed`, `mouseEvent`
- Look in `/home/user/ab-decom/a/k/` for menu actions
- Look in `/home/user/ab-decom/a/j/b/` for canvas events

### Finding File Operations
- All save/load in `/home/user/ab-decom/a/f/`
- JSON format verification in file

### Finding Strings and UI Text
- All UI text in `a.i.c`
- All images in `/imgs/` directory

