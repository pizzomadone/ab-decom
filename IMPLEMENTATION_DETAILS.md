# AlgoBuild Implementation Details - Critical Information for Recreation

## Summary
This document contains all critical implementation details discovered through analyzing the decompiled AlgoBuild source code. Use this as your blueprint for exact recreation.

---

## 1. BLOCK SHAPES AND DIMENSIONS CALCULATION

### Rectangle Block (a.j.b.a)
**File**: `/home/user/ab-decom/a/j/b/a.java` (Lines 33-49)

```java
// Dimension Calculation
this.n = (2 + ((int)Math.ceil((double)this.l / (double)(2 * this.e)) << 1)) * this.e;
this.o = (this.a.length + 1 << 1) * this.f;
// this.n = width, this.o = height

// Rendering
graphics.fillRect(n2 / 2 - this.n / 2, this.f, this.n, this.o);
graphics.drawRect(n2 / 2 - this.n / 2, this.f, this.n, this.o);

// Text rendering
graphics.drawString(this.a[n4], n2 / 2 - this.k[n4] / 2, n3);

// Connection lines
graphics.drawLine(n2 / 2, 0, n2 / 2, this.f);
graphics.drawLine(n2 / 2, n3 - this.f, n2 / 2, n3);
```

**Key Points**:
- Center horizontally: `x = width/2 - blockWidth/2`
- Top padding: `this.f` (font height / 2)
- Bottom padding: `this.f`
- Connection lines: vertical from top to block, then from block to bottom
- Text centered with `width/2 - textWidth/2`

---

### Diamond Shape (a.j.b.j)
**File**: `/home/user/ab-decom/a/j/b/j.java` (Lines 39-62)

```java
// Diamond vertices
int[] nArray = new int[]{
    n2 / 2 - this.o,           // Left point
    n2 / 2 + this.n,           // Right point
    n2 / 2 + this.o,           // Right point (duplicate)
    n2 / 2 - this.n            // Left point (duplicate)
};
int[] nArray2 = new int[]{
    this.f,                    // Top
    this.f,                    // Middle
    this.f + this.p,           // Bottom
    this.f + this.p            // Bottom (duplicate)
};

graphics.fillPolygon(nArray, nArray2, 4);
graphics.drawPolygon(nArray, nArray2, 4);

// Connection lines
graphics.drawLine(n2 / 2, 0, n2 / 2, this.f);
graphics.drawLine(n2 / 2, n3 - this.f, n2 / 2, n3);

// Condition text
graphics.drawString(this.q, n5 + this.b.q().h(), n4 - this.b.q().h());

// TRUE/FALSE paths
int n4 = this.f + this.p;
int n5 = n2 / 2 - this.n + this.e;  // For "I/O" label position
```

**Key Points**:
- 4-point polygon: top center, right middle, bottom center, left middle
- TRUE path flows right
- FALSE path flows down
- Condition text positioned in upper-left area
- Dimensions: `this.o` and `this.n` control diamond size

---

### Parallelogram (I/O Block) (a.j.b.h)
**File**: `/home/user/ab-decom/a/j/b/h.java` (Lines 40-77)

```java
// Parallelogram vertices (6 points creating skewed rectangle)
int[] nArray = new int[]{
    n2 / 2 - this.o,           // Left-top
    n2 / 2 - this.p,           // Left-middle
    n2 / 2 + this.p,           // Right-middle
    n2 / 2 + this.o,           // Right-top
    n2 / 2 + this.p,           // Right-bottom
    n2 / 2 - this.p            // Left-bottom
};
int[] nArray2 = new int[]{
    this.q / 2 + 2 * this.f,   // Top Y
    2 * this.f,                // Upper middle Y
    2 * this.f,                // Upper middle Y
    this.q / 2 + 2 * this.f,   // Top Y
    this.q + 2 * this.f,       // Bottom Y
    this.q + 2 * this.f        // Bottom Y
};

graphics.fillPolygon(nArray, nArray2, 6);
graphics.drawPolygon(nArray, nArray2, 6);

// True/False paths
graphics.drawString("F", n2 / 2 + this.o + 2, this.q / 2 + 2 * this.f - 2);
graphics.drawString("T", n2 / 2 + 2, this.q + 4 * this.f - 2);
```

**Key Points**:
- 6-point polygon creating parallelogram effect
- Offset: `this.o` and `this.p` control skew angle
- Text centered in middle
- "F" and "T" labels for I/O paths
- Used for INPUT and OUTPUT blocks

---

## 2. FONT METRICS AND SIZING

### Font Unit Calculation
**File**: `/home/user/ab-decom/a/j/b/n.java` (Lines 168-176)

```java
public final void g() {
    this.e = this.f = (this.b.q().b().getSize() + 1) / 2;
    this.setFont(this.b.q().b());
}
```

**Key Formula**:
```
e (width unit) = (fontHeight + 1) / 2
f (height unit) = (fontHeight + 1) / 2
```

**Font retrieval**: `this.b.q().b()`
- `this.b` = Document (a.c.a.b)
- `q()` = ViewOptions (a.c.a.i)
- `b()` = Get font

---

## 3. BLOCK RENDERING PIPELINE

### Drawing Order
1. **Call `paintComponent(Graphics g)`** in base panel
2. **Set up Graphics2D**:
   ```java
   ((Graphics2D)graphics).setStroke(this.b.q().l());
   ((Graphics2D)graphics).setRenderingHint(
       RenderingHints.KEY_ANTIALIASING, 
       RenderingHints.VALUE_ANTIALIAS_ON
   );
   ```
3. **Call shape-specific `a(Graphics g)`** method
4. **Draw connections** (lines and arrows)
5. **Draw text** with center alignment

### Text Rendering
```java
// Get string bounds
Rectangle2D bounds = fontMetrics.getStringBounds(text, graphics);

// Calculate Y position (vertically centered)
int y = (int)((double)(3 * this.f) - bounds.getHeight() / 2.0 - bounds.getY());

// Draw string
graphics.drawString(text, x, y);
```

---

## 4. COLOR MANAGEMENT

### View Options Color Methods
**File**: `/home/user/ab-decom/a/c/a/i.java`

```java
// Access pattern: document.q().<method>()
q().e()  // Normal block background color
q().f()  // Execution highlight background
q().g()  // Hover state background
q().h()  // Margin/spacing width
q().i()  // Normal border color
q().j()  // Execution highlight border color
q().k()  // Hover border color
q().l()  // Stroke for drawing
q().m()  // Arrow size
```

### Color Selection Pattern
```java
protected final void b(Graphics graphics) {
    if (this.g) {  // g = hover flag
        graphics.setColor(this.b.q().g());  // Hover color
    } else {
        graphics.setColor(this.b.q().e());  // Normal color
    }
}
```

---

## 5. EXECUTION HIGHLIGHTING

### Execution State Tracking
**File**: `/home/user/ab-decom/a/c/a/c.java`

```java
public final class c {
    private int a = -1;        // Execution status
    private d b;               // Current executable
    private b c;               // Document reference
}
```

### During Execution
**File**: `/home/user/ab-decom/a/c/a/e.java`

```java
public final void a(String object) {
    object = this.a.a((String)object);  // Get code block
    c c2 = new c((d)object, this.a);     // Create context
    this.a.d().push(c2);                 // Push to execution stack
}
```

### Block Highlighting
**File**: `/home/user/ab-decom/a/j/b/o.java` (Lines 125-142)

```java
protected final void a(Graphics graphics, int n2) {
    c c2 = this.b.a();  // Get current context
    if (c2 == null) {
        // Not executing
        if (this.g || this.b.j() == this.i) {
            graphics.setColor(this.b.q().g());  // Highlight if hover
        } else {
            graphics.setColor(this.b.q().e());  // Normal color
        }
    } else {
        a.c.a.d d2 = c2.d();  // Get current block
        if (d2 == this.i && c2.c() == n2 && d2.a(n2)) {
            graphics.setColor(this.b.q().f());  // Execution highlight
        } else {
            graphics.setColor(this.b.q().e());  // Normal color
        }
    }
}
```

---

## 6. CONNECTOR/ARROW IMPLEMENTATION

### Connector Rendering (a.j.b.f)
**File**: `/home/user/ab-decom/a/j/b/f.java` (Lines 43-73)

```java
public final void a(Graphics graphics) {
    c c2 = this.b.a();  // Get execution context
    
    int n2 = this.getWidth();
    int n3 = this.getHeight();
    int n4 = (int)((double)this.b.q().h() * b_0.a());  // Margin
    int n5 = (int)((double)this.b.q().m() * b_0.a());  // Arrow size
    
    this.c(graphics);  // Set border color
    
    if (this.g && object == null) {
        // Hover state with no execution
        this.b(graphics);
        graphics.fillRect(0, 0, n2 - 1, n3 - 1);
        // Draw "NEW" text
    }
    
    // Draw connector line
    graphics.drawLine(n2 / 2, 0, n2 / 2, n3);
    
    // Draw arrow head
    graphics.drawLine(n2 / 2, n3 - n7, n2 / 2 - n5, n3 - n5 - n7);
    graphics.drawLine(n2 / 2, n3 - n7, n2 / 2 + n5, n3 - n5 - n7);
}
```

**Key Points**:
- Center connector: `n2 / 2` (middle of width)
- Arrow head: Two lines forming V-shape pointing up
- Arrow size: `this.b.q().m()` (configurable)
- Shows "NEW" text on hover

---

## 7. NESTED BLOCK CONTAINER

### Container for Nested Instructions (a.j.b.e)
**File**: `/home/user/ab-decom/a/j/b/e.java`

```java
public final void a() {
    Dimension dimension = new Dimension(2 * this.e, 0 * this.f);
    Component[] componentArray = this.getComponents();
    
    // Calculate dimensions from children
    int n2 = 0;
    while (n2 < componentArray.length) {
        if (componentArray[n2] instanceof n) {
            ((n)componentArray[n2]).g();  // Recalculate child
        }
        Dimension dimension2 = componentArray[n2].getMinimumSize();
        
        // Track widest and accumulate height
        if (dimension2.width > dimension.width) {
            dimension.width = dimension2.width;
        }
        dimension.height += dimension2.height;
        ++n2;
    }
    
    this.a(dimension);  // Set container size
    
    // Position children vertically centered
    n2 = 0;
    int n3 = 0;
    while (n3 < componentArray.length) {
        Dimension dimension3 = componentArray[n3].getMinimumSize();
        int n4 = (int)(dimension.getWidth() - dimension3.getWidth()) / 2;
        componentArray[n3].setLocation(n4, n2);
        n2 = (int)((double)n2 + dimension3.getHeight());
        ++n3;
    }
}
```

**Key Points**:
- Vertical stacking of child blocks
- Children centered horizontally
- Total height = sum of child heights
- Total width = max child width

---

## 8. FILE FORMAT DETAILS

### Save Method (a.c.a.b)
**File**: `/home/user/ab-decom/a/c/a/b.java` (Lines 385-427)

```java
private b.a.c t() {
    b.a.c c2 = new b.a.c();
    c2.b("abiid", "ABEENV");
    
    // Serialize all code blocks
    Object object = this.d.a();  // Get all procedures
    object = object.iterator();
    while (object.hasNext()) {
        Object object2 = (q)object.next();
        object2 = ((q)object2).b(true);  // Serialize procedure
        c2.a("codepool", object2);
    }
    
    // Save view options and history
    c2.b("viewOptions", this.k.n());
    c2.b("saveHistory", this.p.a());
    
    return c2;
}

public final void j(String object) {
    // Save with signature
    Object object3 = a.f.f.a();
    String string = a.f.k.a().d();  // Get author serial
    
    ((a.f.f)object3).a((String)object, (b.a.c)object2);
    this.j = false;
}
```

### Load Method (a.c.a.b)
**File**: `/home/user/ab-decom/a/c/a/b.java` (Lines 429-480)

```java
public final void k(String object4) {
    Iterator iterator = a.f.f.a();
    try {
        iterator = ((a.f.f)((Object)iterator)).a((String)object4);
        
        // Clear existing
        b2.b();
        b2.d.b();
        
        // Load view options
        if ((iterator = ((b.a.c)((Object)iterator22)).e("viewOptions")) != null) {
            b2.k.a((b.a.c)((Object)iterator));
        }
        
        // Load code pool
        if ((iterator = ((b.a.c)((Object)iterator22)).d("codepool")) != null) {
            int n2 = 0;
            while (n2 < ((b.a.a)((Object)iterator)).a()) {
                object2 = ((b.a.a)((Object)iterator)).c(n2);
                n n3 = a.c.b.n.a((b.a.c)object2);
                n3.a((b.a.c)object3, true);
                
                if (n3 instanceof q) {
                    b2.a((q)n3);
                }
                ++n2;
            }
        }
        
        this.j = false;
    } catch (h h2) {
        JOptionPane.showMessageDialog(null, h2.getMessage());
    }
}
```

**JSON-like Structure**:
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

---

## 9. EXECUTION ENGINE FLOW

### Step-by-Step Execution
**File**: `/home/user/ab-decom/a/c/a/e.java`

```java
public final void c() {
    boolean bl = this.b();  // Check if running
    while (bl) {
        Object object = (c)this.a.d().peek();  // Get top context
        
        if (object != null) {
            ((c)object).a();  // Execute step
            
            if (((c)object).c() == -2) {
                this.a.d().clear();  // Clear on error
            }
            
            if ((object = ((c)object).d()) instanceof n) {
                ((n)object).a(false);  // Update block state
            }
        }
        
        if (this.a.d().empty()) {
            bl = false;
            continue;
        }
        
        object = (c)this.a.d().peek();
        if (object == null || ((c)object).b()) {
            bl = false;  // Pause or end
        }
        
        if (object == null || !((object = ((c)object).d()) instanceof n)) continue;
        ((n)object).a(false);  // Update UI
    }
}
```

### Block Execution
**File**: `/home/user/ab-decom/a/c/b/n.java`

Each block implements:
```java
@Override
public int a(b document, int index) {
    // Execute block logic
    // Return next index or -1 for end
}
```

---

## 10. BLOCK TYPE IDENTIFIERS

### Type Strings for Serialization
```
"ABIASS"  → Assignment (a.c.b.a)
"ABICAL"  → Function call (a.c.b.c)
"ABICOM"  → Comment (a.c.b.d)
"ABIDOW"  → Do-While (a.c.b.e)
"ABIFOR"  → For loop (a.c.b.f)
"ABIWHI"  → While loop (a.c.b.g)
"ABIINP"  → Input (a.c.b.i)
"ABIOUT"  → Output (a.c.b.j)
"ABIIF_"  → If statement (a.c.b.l)
"ABRCOD"  → Procedure/Function (a.c.b.q)
```

### Deserialization
**File**: `/home/user/ab-decom/a/c/b/n.java` (Lines 99-124)

```java
public static n a(b.a.c object) {
    object = (String)((b.a.c)object).c("abiid");
    n n2 = null;
    
    if (((String)object).equals("ABIASS")) {
        n2 = new a();
    } else if (((String)object).equals("ABICAL")) {
        n2 = new c();
    } else if (((String)object).equals("ABICOM")) {
        n2 = new d();
    } // ... etc for all types
    
    return n2;
}
```

---

## 11. UNDO/REDO STACK MANAGEMENT

### Stack Operations
**File**: `/home/user/ab-decom/a/j/a/g.java` (Lines 342-416)

```java
public final void a(a.g.g g2) {
    this.t.push(g2);           // Push to undo stack
    if (!this.u.empty()) {
        this.u.removeAllElements();  // Clear redo on new action
    }
    this.a.a("mnuEditUndo", true);
    this.a.a("mnuEditRedo", false);
}

public final void o() {  // Undo
    if (this.m()) {
        a.g.g g2 = (a.g.g)this.t.pop();
        g2.b();  // Undo operation
        this.u.push(g2);
        this.a.a("mnuEditUndo", this.m());
        this.a.a("mnuEditRedo", this.n());
    }
}

public final void p() {  // Redo
    if (this.n()) {
        a.g.g g2 = (a.g.g)this.u.pop();
        g2.a();  // Redo operation
        this.t.push(g2);
        this.a.a("mnuEditUndo", this.m());
        this.a.a("mnuEditRedo", this.n());
    }
}
```

---

## 12. PATH NOTATION FOR BLOCKS

### How Paths Work
```
"main"       → Main procedure
"main.0"     → First instruction in main
"main.0.1"   → Second instruction in first block (for nested blocks)
"procName.5" → Sixth instruction in procName

// For composite blocks:
"main.2.0"   → First instruction inside 3rd block in main
"main.2.0.1" → Second instruction inside nested block
```

### Path Generation
**File**: `/home/user/ab-decom/a/c/b/n.java` (Lines 41-55)

```java
@Override
public String c() {
    if (this.b != null) {  // Has parent
        String string = this.b.c();  // Get parent path
        if (this.c >= 0) {
            return String.valueOf(string) + "." + this.c;
        }
        return string;
    }
    return Integer.toString(this.c);
}
```

---

## 13. TIMER-BASED EXECUTION

### Execution Timer Setup
**File**: `/home/user/ab-decom/a/j/a/g.java` (Lines 57-78)

```java
this.d = new Timer(1000, (ActionListener)object);
((g)object).d.setInitialDelay(10);

// In action listener
public final void actionPerformed(ActionEvent actionEvent) {
    if (actionEvent.getSource() == this.d) {
        if (this.c.b()) {
            this.c.c();  // Execute one step
        } else {
            this.d.stop();  // Stop timer when done
        }
        
        // Update button states
        boolean bl = this.c.b();
        boolean bl2 = this.b.r().b();
        this.a.a("execInstruction", !bl || bl2);
        this.a.a("execPause", bl && !bl2);
        this.a.a("execInterrupt", bl);
    }
}
```

**Default**: 1000ms (1 second) per step
**Configurable**: Via execution options dialog

---

## 14. CRITICAL MEASUREMENTS

### Standard Block Sizes

#### Rectangle (for assignment)
```
Minimum width = 22 * e (where e = font_size/2)
Height = line_count * 2 * f + 2 * f padding
```

#### Diamond (for IF)
```
Width = 2 * (widest_line/2 + e)
Height = (lines + 1) * 2 * f
```

#### Parallelogram (for I/O)
```
Width = 2 * offset + diagonal_offset
Height = lines * 2 * f + padding
```

### Connection Spacing
```
Vertical gap between blocks = 1 * f (one font height unit)
Horizontal margin = e (font height / 2)
Arrow head width = typically 5-10 pixels
Arrow head height = typically 5-10 pixels
```

---

## 15. KEYBOARD AND MOUSE EVENTS

### Mouse Event Handling (a.j.b.f)
**File**: `/home/user/ab-decom/a/j/b/f.java` (Lines 96-146)

```java
public final void a(MouseEvent mouseEvent) {
    Object object = null;
    Object object2 = this.b.a();
    if (object2 != null) {
        object = this.b.a().d();  // Check if executing
    }
    
    if (object != null) {
        return;  // Don't show menu during execution
    }
    
    // Build context menu
    JPopupMenu jPopupMenu = new JPopupMenu();
    
    // Add items:
    // - New instruction options
    // - Paste option (if clipboard available)
    
    jPopupMenu.show(mouseEvent.getComponent(), 
                    mouseEvent.getX(), 
                    mouseEvent.getY());
}
```

### Keyboard Shortcuts
**File**: `/home/user/ab-decom/a/k/c.java` (Line 151)

```java
object.putValue("AcceleratorKey", KeyStroke.getKeyStroke(120, 0));
// 120 = 'x' key
```

---

## 16. VARIABLE DISPLAY FORMAT

### Variable Output Format
**File**: `/home/user/ab-decom/a/c/a/b.java` (Lines 116-144)

```java
public final void i() {
    String string = "";
    String string2 = "VARIABLES:\n";
    
    Object object2 = this.c();  // Get variable map
    if (object2 != null) {
        object2 = object2.entrySet();
        Iterator iterator = object2.iterator();
        while (iterator.hasNext()) {
            object2 = iterator.next();
            string = String.valueOf(string) + " | " + 
                    (String)object2.getKey() + "=" + 
                    ((c.f)object2.getValue()).b();
            string2 = String.valueOf(string2) + 
                    (String)object2.getKey() + "=" + 
                    ((c.f)object2.getValue()).a() + "\n";
        }
    }
    
    if (string.length() > 0) {
        string = "    VAR: " + string + " |";
    }
}
```

**Format**:
```
VAR: varname=value | varname=value | ...
```

---

## 17. CRUCIAL IMPLEMENTATION WARNINGS

### MUST IMPLEMENT CORRECTLY:
1. **Block Path Notation**: Exact dot notation (main.0.1.2)
2. **Font Metrics**: All sizes based on FontMetrics, not fixed values
3. **Graphics2D Setup**: Antialiasing and stroke rendering
4. **Centered Text**: Every text element must be center-aligned
5. **Connection Lines**: Must include arrow heads pointing upward
6. **Execution Highlighting**: Color changes during execution
7. **Undo/Redo**: Stack-based with proper state tracking
8. **Nested Rendering**: Recursive rendering for composite blocks

### DON'T HARDCODE:
- Block dimensions (calculate from font metrics)
- Colors (get from ViewOptions)
- Text strings (use localization system)
- Image paths (use resource loader)
- Window sizes (use screen size * percentage)

### MUST PRESERVE:
- Block type identifiers (ABIASS, etc.)
- File format structure (JSON with codepool)
- Execution flow (stack-based with contexts)
- UI layout (tabbed editor, split panes)
- Menu structure (exactly as shown)

---

## 18. TESTING CHECKPOINTS

### Minimal Feature Test:
1. Can create and display rectangle block
2. Can create and display diamond IF block
3. Can create and display parallelogram I/O block
4. Blocks have correct centered text
5. Connection lines visible between blocks

### Medium Feature Test:
1. Can execute simple algorithm step-by-step
2. Block highlights during execution
3. Can create nested blocks
4. Can undo/redo operations
5. Variables display correctly

### Full Feature Test:
1. Save and load algorithm from file
2. All 10 block types render correctly
3. Font zoom works on high-DPI displays
4. All menu items functional
5. Execution with pause/resume works
6. Language switching works

---

