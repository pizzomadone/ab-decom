# AlgoBuild Complete Architecture Analysis

## Overview
AlgoBuild is a visual flowchart programming editor written in Java with a GUI for creating, editing, and executing flowchart-based algorithms. The original code uses heavy obfuscation with single-letter package and class names.

---

## 1. ENTRY POINT AND STARTUP

### Main Entry Point
- **File**: `AlgoBuildBootLoader.java`
- **Entry Class**: `a.c.a.a.main(String[] args)`
- **Startup Sequence**:
  1. Sets cross-platform look and feel (Swing UIManager)
  2. Parses command-line arguments for font zoom settings
  3. Auto-detects high-resolution displays and applies zoom
  4. Initializes configuration and calls `a.k.B.run()` via `SwingUtilities.invokeLater()`

### Initialization Classes
- **a.k.B** (Runnable): Main startup task that calls:
  - `a.f.k.a()` - Configuration initialization
  - `a.f.f.a()` - File manager initialization
  - `a.k.c.a()` - Main window creation (singleton)

---

## 2. MAIN WINDOW STRUCTURE

### Main Window Class
- **Class**: `a.k.c` (Singleton)
- **Frame**: `a.k.c_0` (extends JFrame)
- **Key Components**:
  - Menu bar with File, Edit, Run, Language, Author, Help menus
  - Toolbar with action buttons (New, Open, Save, Undo, Redo, etc.)
  - Content area with tabbed editor panel
  - Status/console output area

### Menu Items and Actions
- **File**: New, Open, Save, Save As, Save Image, Exit
- **Edit**: Undo, Redo, Copy Image, Font/Line Options
- **Run**: Execute Instruction, Pause, Interrupt, Execution Options
- **Language**: English, Italian
- **Author**: History, Author Info, Registration
- **Help**: Online Help, Function Help, Website, About

---

## 3. EDITOR PANEL ARCHITECTURE

### Main Editor Panel
- **Class**: `a.j.a.g` (extends JPanel)
  - Contains the entire editor UI with split panes
  - Manages block palette, flowchart canvas, code tabs, and output console

### Components of a.j.a.g:
1. **Block Palette/Toolbox** (`a.j.a.a`)
   - Tabbed interface for different code sections (procedures, functions)
   - "+" tab for creating new code blocks

2. **Flowchart Canvas**
   - Main drawing area for visualizing algorithm structure
   - Supports scrolling and zooming
   - Nested structure for composite blocks (loops, conditions)

3. **Output Console** (`a.j.a.c`)
   - Text output during execution
   - Shows variable values and print output

4. **Execution Context**
   - Tracks current execution position
   - Manages breakpoints and step-through execution

---

## 4. FLOWCHART DRAWING ARCHITECTURE

### Canvas Hierarchy
```
a.j.b.n (Base Drawing Panel)
  └── a.j.b.o (Instruction Container)
      ├── a.j.b.a (Rectangle - Assignment)
      ├── a.j.b.j (Diamond - IF Condition)
      ├── a.j.b.h (Parallelogram - Input/Output)
      ├── a.j.b.k (Call block)
      ├── a.j.b.g (Loop block)
      ├── a.j.b.i (While block)
      ├── a.j.b.l (Do-While block)
      ├── a.j.b.m (Comment block)
      ├── a.j.b.e (Nested instruction container)
      ├── a.j.b.d (Block)
      ├── a.j.b.c_0 (Procedure/Function container)
      ├── a.j.b.b_0 (Function call)
      └── a.j.b.f (Connector/Arrow)
```

### Drawing Engine
- **Base Panel**: `a.j.b.n` - Provides:
  - Graphics2D setup with antialiasing
  - Mouse event handling
  - Font metrics calculation
  - Stroke and color management

- **Rendering Methods**:
  - `paintComponent(Graphics)` - Main rendering entry point
  - `a(Graphics)` - Abstract method for shape-specific drawing
  - Uses `Graphics2D` for advanced rendering

### Coordinate System
- Each block has an `e` (width unit) and `f` (height unit) based on font size
- Sizes calculated from font metrics at runtime
- Layout manager positions blocks relative to parent container

---

## 5. BLOCK TYPE MAPPING

### Shape Types by Block Type

| Block Type | Class | Shape | Key Features |
|-----------|-------|-------|--------------|
| Assignment/Simple | `a.c.b.a` | Rectangle | Basic computation block |
| Input (READ) | `a.c.b.i` | Parallelogram | I/O operation |
| Output (WRITE) | `a.c.b.j` | Parallelogram | I/O operation |
| IF Condition | `a.c.b.l` | Diamond | Decision point with TRUE/FALSE paths |
| FOR Loop | `a.c.b.f` | Composite | Contains initialization, condition, update |
| WHILE Loop | `a.c.b.g` | Composite | Condition checked at start |
| DO-WHILE Loop | `a.c.b.e` | Composite | Condition checked at end |
| Comment | `a.c.b.d` | Rectangle | Documentation block |
| Function Call | `a.c.b.c` | Rectangle | Calls procedure/function |
| Procedure | `a.c.b.q` | Special | Main program or custom procedure |

### Type Identifiers
- ABIASS - Assignment
- ABIINP - Input
- ABIOUT - Output
- ABIIF_ - IF Statement
- ABIFOR - FOR Loop
- ABIWHI - WHILE Loop
- ABIDOW - DO-WHILE Loop
- ABICOM - Comment
- ABICAL - Function Call
- ABRCOD - Procedure/Code Block

---

## 6. SHAPE DRAWING DETAILS

### Rectangle Block (a.j.b.a)
```java
graphics.fillRect(x, y, width, height);
graphics.drawRect(x, y, width, height);
graphics.drawString(text, textX, textY);
```
- Dimensions calculated from text metrics
- Centered text rendering
- Connection lines to previous/next blocks

### Diamond Shape (a.j.b.j)
```java
int[] xPoints = {centerX - halfWidth, centerX + halfWidth, 
                 centerX + halfWidth, centerX - halfWidth};
int[] yPoints = {topY, middleY, topY + height, middleY};
graphics.fillPolygon(xPoints, yPoints, 4);
graphics.drawPolygon(xPoints, yPoints, 4);
```
- 4-point polygon forming diamond
- TRUE path flows right
- FALSE path flows down
- Condition text centered

### Parallelogram Block (a.j.b.h)
```java
int[] xPoints = {centerX - width/2 - offset, centerX - width/2 + offset,
                 centerX + width/2 + offset, centerX + width/2 - offset};
int[] yPoints = {topY, topY + height, topY + height, topY};
graphics.fillPolygon(xPoints, yPoints, 4);
```
- Skewed rectangle for I/O
- Offset creates parallelogram effect
- Input/output text centered

### Connector/Arrow (a.j.b.f)
```java
graphics.drawLine(centerX, topY, centerX, bottomY);
graphics.drawLine(centerX, endY, centerX - arrowWidth, endY - arrowHeight);
graphics.drawLine(centerX, endY, centerX + arrowWidth, endY - arrowHeight);
```
- Vertical line connecting blocks
- Arrow head at connection point
- Allows right-click to add new blocks

---

## 7. DATA MODEL STRUCTURE

### Core Classes

#### a.c.a.b (Document/Algorithm)
- Central data model containing all blocks and code
- Methods:
  - `a()` - Get current execution context
  - `b()` - Clear all blocks
  - `a(String, int)` - Create new code block (procedure/function)
  - `a(d)` - Set current selection
  - `j(String)` - Save to file
  - `k(String)` - Load from file

#### a.c.a.d (Base Instruction - Abstract)
- Parent class for all block types
- Methods:
  - `a(b, int)` - Execute step (returns next instruction index)
  - `b()` - Get description
  - `c()` - Get path identifier
  - `c(int)` - Get child instruction by index
  - `a(n)` - Add instruction
  - `d(int)` - Remove instruction

#### a.c.b.n (Instruction - Extends d)
- All block types inherit from this
- Contains execution state tracking
- Methods:
  - `a(a.c.a.d, int)` - Set parent and position
  - `n()` - Get order in parent
  - `c()` - Get full path (e.g., "main.0.1")

### Block Hierarchy
```
a.c.a.d (Base Executable)
  └── a.c.b.n (Instruction Base)
      ├── a.c.b.a (Assignment)
      ├── a.c.b.c (Function Call)
      ├── a.c.b.d (Comment)
      ├── a.c.b.e (Do-While)
      ├── a.c.b.f (For Loop)
      ├── a.c.b.g (While Loop)
      ├── a.c.b.i (Input)
      ├── a.c.b.j (Output)
      ├── a.c.b.l (If Statement)
      └── a.c.b.q (Procedure/Function)
```

---

## 8. EXECUTION ENGINE

### Execution Architecture

#### a.c.a.e (Executor)
- Manages algorithm execution
- Methods:
  - `a(String)` - Start execution of named code block
  - `b()` - Check if execution is running
  - `c()` - Step through execution
  - `a()` - Stop execution and clear

#### a.c.a.c (Execution Context/Stack Frame)
- Represents current execution state
- Tracks:
  - Current instruction being executed
  - Current position in instruction sequence
  - Local variables in current scope
- Methods:
  - `a()` - Execute next step
  - `b()` - Check if paused
  - `c()` - Get status
  - `d()` - Get current executable

### Execution Flow
1. User clicks "Execute" button
2. Executor creates execution context for "main"
3. Timer fires every 1000ms (default, user-configurable)
4. Each tick calls `c()` which:
   - Gets current instruction
   - Calls `a(context, index)` to execute
   - Returns next instruction index (-1 = end)
5. On completion, clears execution context

---

## 9. FILE FORMAT AND PERSISTENCE

### Save Format
- **Extension**: `.algobuild`
- **Format**: JSON-based structure (via `a.f.f`)

### File Structure
```json
{
  "abiid": "ABEENV",
  "codepool": [
    {
      "abiid": "ABRCOD",
      "name": "main",
      "type": 1,
      "instructions": [...]
    }
  ],
  "viewOptions": {...},
  "saveHistory": {...}
}
```

### Serialization Classes
- **a.f.f** - File I/O handler
- **a.f.g** - Object serialization
- **a.c.a.b** - Saves via `j(String)` method
- **a.c.b.n** - Each instruction serializes itself

### Save History
- **a.c.a.g** - Tracks modification history
- Stores serial number, author, build info
- User registration information

---

## 10. CONNECTOR IMPLEMENTATION (a.j.b.f)

### Connector Features
- **Purpose**: Connects blocks and allows insertion of new blocks
- **Rendering**:
  - Vertical line with arrow head
  - Shows "NEW" text on hover
  - Changes color based on execution/hover state

### Right-Click Menu
When user right-clicks on connector:
- New Instruction options:
  - Assignment
  - Input
  - Output
  - If Statement
  - For Loop
  - While Loop
  - Do-While Loop
  - Comment
  - Function Call
- Paste option (if block in clipboard)

### Connector Actions (a.j.b.f.actionPerformed)
- Creates new block of selected type
- Calls appropriate dialog for initialization
- Adds block at correct position
- Updates undo/redo stack

---

## 11. COLOR AND STYLING

### Color Management (a.c.a.i)
- Managed through `a.c.a.i` (ViewOptions)
- Colors by state:
  - Normal block background: `q().e()`
  - Normal block border: `q().i()`
  - Highlighted block background: `q().g()`
  - Highlighted block border: `q().k()`
  - During execution background: `q().f()`
  - During execution border: `q().j()`
  - Hover state: `q().g()`

### Font Management
- Font: `q().b()` - Gets configured font
- Font size scales with resolution
- All blocks use monospace font for consistency

---

## 12. UNDO/REDO SYSTEM

### Implementation
- **Stack-based** using `java.util.Stack`
- **a.j.a.g** maintains:
  - `t` - Undo stack
  - `u` - Redo stack

### Operation Types
- Base class: `a.g.g` (Undoable operation)
- Methods:
  - `a()` - Redo
  - `b()` - Undo

### Examples
- `a.g.a` - Block addition
- `a.g.b` - Block deletion
- `a.g.c` - Block modification
- `a.g.e` - Execution-related changes
- `a.g.f` - Multi-action operations

---

## 13. EVENT HANDLING AND INTERACTION

### Mouse Events
- **a.j.b.n** - Base panel mouse listener
- **a.j.b.o** - Instruction panel mouse handler
- **a.j.b.f** - Connector mouse handler (right-click for new blocks)

### Actions and Commands
- **a.k.a_0** - Action manager (stores and retrieves actions by key)
- Icons loaded from: `imgs/` directory
- Keyboard shortcuts via `KeyStroke`

### Block Editing
- Right-click on block shows context menu:
  - Modify (edit block properties)
  - Copy (copy to clipboard)
  - Cut (cut and copy to clipboard)
  - Delete (remove from flowchart)

---

## 14. LANGUAGE AND LOCALIZATION

### Localization System
- **Class**: `a.i.c`
- **Resource Keys**: English and Italian strings
- **Supported Languages**: English (en_US), Italian (it_IT)
- **Menu Items, Messages**: All externalized

### Language Switch
- User selects language from menu
- All UI elements updated via `SwingUtilities.invokeLater()`
- Current language stored in preferences

---

## 15. IMAGES AND RESOURCES

### Image Resources
- Located in `imgs/` directory
- Loaded via `a.i.b.a(String)`
- Images used:
  - Block type icons (assign_icon.gif, input_icon.gif, etc.)
  - Toolbar icons (new_icon.gif, open_icon.gif, save_icon.gif, etc.)
  - Language flags (flag_it.gif, flag_gb.gif)
  - Logo (logo2_arancio_small.png)

---

## 16. VARIABLE EXECUTION AND CONTEXT

### Variable Tracking
- **Local variables** stored in execution context
- **Class**: Map in `a.c.a.b`
- Accessed during:
  - Assignment execution
  - Expression evaluation
  - Input/output operations

### Variable Display
- Variables shown in console during execution
- Updated each step
- Format: "VAR: varname=value | varname=value |"

---

## 17. COMPOSITE BLOCKS (LOOPS AND CONDITIONS)

### Structure
- IF blocks:
  - Condition expression
  - TRUE branch (nested blocks)
  - FALSE branch (nested blocks)

- FOR/WHILE/DO-WHILE blocks:
  - Loop expressions
  - Body (nested blocks)

### Rendering
- **a.j.b.e** - Container for nested blocks
- Vertical stacking of child blocks
- Connected with vertical lines

### Layout
- Centered children with equal spacing
- Auto-height based on children
- Synchronized updates when children change

---

## 18. PROCEDURES AND FUNCTIONS

### Procedure Container
- **Class**: `a.c.b.q`
- **Types**:
  - Main program (type 1)
  - Procedure (type 2) - returns nothing
  - Function (type 3) - returns value

### Rendering (a.j.b.c_0)
- START block (top rounded shape)
- Procedure/function name
- Parameters
- Nested instructions
- END block (bottom rounded shape)
- Return type for functions

### Execution
- Each procedure is independently executable
- Can call other procedures via function call block
- Stack-based call handling

---

## 19. EXPRESSION EVALUATION

### Classes
- **a.c.a.a** - Expression parser and evaluator
- Handles:
  - Arithmetic expressions
  - Boolean conditions
  - Variable substitution
  - Function calls within expressions

---

## 20. PERFORMANCE AND OPTIMIZATION

### Font Metrics Caching
- Calculated once per font change
- Stored in block drawing classes
- Prevents repeated calculation

### Rendering Optimization
- Only repaints dirty regions
- Uses `revalidate()` to trigger layout
- Graphics2D antialiasing for smooth rendering

### Execution Performance
- 1000ms default execution delay (configurable)
- Step execution for debugging
- Pause/resume support

---

## 21. KEY PACKAGE STRUCTURE

```
a/
├── a/ - Block/instruction model classes
│   ├── a.java - Base operations (assignment, etc.)
│   ├── b.java - Function call operations
│   ├── c-n.java - Various operation types
├── c/a/ - UI and main window
│   ├── a.java - Application startup
│   ├── b.java - Document model
│   ├── d.java - Instruction interface
│   ├── e.java - Executor
│   ├── c.java - Execution context
├── f/ - File I/O and resources
├── g/ - Undo/Redo operations
├── i/ - Localization and resources
├── j/a/ - Main editor panel
│   └── g.java - Central editor
├── j/b/ - Drawing and shape rendering
│   ├── a.java - Rectangle (Assignment)
│   ├── e.java - Nested container
│   ├── f.java - Connector
│   ├── j.java - Diamond (IF)
│   ├── h.java - Parallelogram (I/O)
│   ├── n.java - Base drawing panel
│   └── o.java - Instruction panel
├── k/ - Main window components
│   ├── B.java - Startup
│   ├── c.java - Main frame
│   ├── c_0.java - Frame class
└── [Other packages with action handlers and utilities]
```

---

## 22. CRITICAL INFORMATION FOR RECREATION

### Must-Have Features
1. **Block Types**: 10 different flowchart block types
2. **Shapes**: Rectangles, diamonds, parallelograms
3. **Nesting**: Composite blocks for loops and conditions
4. **Connections**: Lines with arrows connecting blocks
5. **Execution**: Step-through execution with highlighting
6. **Save/Load**: JSON or custom format for persistence
7. **Undo/Redo**: Full command history
8. **Variables**: Runtime variable tracking and display
9. **Languages**: Multi-language UI support
10. **Icons**: 20+ icons for UI elements

### Critical Algorithms
1. **Block Layout**: Calculate position based on font metrics
2. **Nested Rendering**: Recursive rendering of composite blocks
3. **Execution**: Stack-based interpreter for algorithm execution
4. **Path Tracking**: Dot-notation for block identification (e.g., "main.0.1")

### File Format Requirements
- Must serialize all blocks with their properties
- Must preserve execution metadata
- Must support version information
- Must include user preferences and history

---

## 23. EXECUTION STATES AND TRANSITIONS

### Block Execution States
- **NOT_STARTED** (-1): Hasn't been executed
- **RUNNING** (0): Currently executing
- **PAUSED** (1): Paused during execution
- **COMPLETED** (2): Finished execution

### Execution Loop
1. Timer fires every N milliseconds
2. Executor calls `c()` (step execution)
3. Current block executes
4. Next block determined from return value
5. If block is highlighted on canvas
6. Repeat until execution ends or paused

---

## 24. KEY DESIGN PATTERNS

### Model-View-Controller
- **Model**: `a.c.a.b` (Document with blocks)
- **View**: `a.j.a.g`, `a.j.b.*` (Drawing classes)
- **Controller**: `a.k.c` (Main window controller)

### Observer Pattern
- Blocks notify viewers of changes
- View options observable by all blocks
- Execution state observable by UI

### Composite Pattern
- Blocks can contain other blocks
- Recursive rendering and execution
- Tree structure for algorithms

### Strategy Pattern
- Different block types have different execution strategies
- `a(b, int)` method implemented differently per type

### Command Pattern
- Undo/Redo operations as commands
- Each operation implements `a()` and `b()`

---

## 25. IMPORTANT NOTES FOR COMPLETE RECREATION

### High Priority
1. **Exact Shape Rendering**: Must match original precisely
2. **Block Connection Lines**: Include arrow heads and proper angles
3. **Font Metrics Integration**: All sizes based on font metrics
4. **Zoom Sensitivity**: Must support font zoom for high-DPI displays
5. **Execution Highlighting**: Must highlight blocks during execution
6. **Path Notation**: Must use "procedure.index.index" format

### Medium Priority
1. Animation of execution flow
2. Performance with large algorithms
3. Clipboard integration for copy/paste
4. Keyboard shortcuts and mnemonics
5. Status bar updates

### Lower Priority
1. Advanced styling options
2. Custom color themes
3. Block documentation
4. Code generation

