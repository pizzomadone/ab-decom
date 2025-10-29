#!/bin/bash

# Script per creare una struttura leggibile del progetto
# Copia i file con nomi descrittivi e aggiunge header di documentazione

SRC_DIR="/home/user/ab-decom"
DEST_DIR="/home/user/ab-decom/src"

# Funzione per aggiungere header documentazione
add_header() {
    local file=$1
    local desc=$2
    local original=$3

    echo "/*" > "$file.tmp"
    echo " * AlgoBuild - Decompiled and refactored for readability" >> "$file.tmp"
    echo " * Original: $original" >> "$file.tmp"
    echo " * Description: $desc" >> "$file.tmp"
    echo " */" >> "$file.tmp"
    tail -n +4 "$file" >> "$file.tmp"
    mv "$file.tmp" "$file"
}

echo "Creazione struttura leggibile..."

# Package JSON (b.a)
mkdir -p "$DEST_DIR/com/algobuild/json"
cp "$SRC_DIR/b/a/a.java" "$DEST_DIR/com/algobuild/json/JSONArray.java"
cp "$SRC_DIR/b/a/b.java" "$DEST_DIR/com/algobuild/json/JSONException.java"
cp "$SRC_DIR/b/a/c.java" "$DEST_DIR/com/algobuild/json/JSONObject.java"
cp "$SRC_DIR/b/a/d.java" "$DEST_DIR/com/algobuild/json/JSONNull.java"
cp "$SRC_DIR/b/a/e.java" "$DEST_DIR/com/algobuild/json/JSONString.java"
cp "$SRC_DIR/b/a/f.java" "$DEST_DIR/com/algobuild/json/JSONTokenizer.java"

# Package Expression (c)
mkdir -p "$DEST_DIR/com/algobuild/expression"
cp "$SRC_DIR/c/a.java" "$DEST_DIR/com/algobuild/expression/ExpressionParser.java"
cp "$SRC_DIR/c/b.java" "$DEST_DIR/com/algobuild/expression/OperatorType.java"
cp "$SRC_DIR/c/c.java" "$DEST_DIR/com/algobuild/expression/TokenType.java"
cp "$SRC_DIR/c/g.java" "$DEST_DIR/com/algobuild/expression/ExpressionException.java"
cp "$SRC_DIR/c/h.java" "$DEST_DIR/com/algobuild/expression/BooleanValue.java"
cp "$SRC_DIR/c/i.java" "$DEST_DIR/com/algobuild/expression/DoubleValue.java"
cp "$SRC_DIR/c/j.java" "$DEST_DIR/com/algobuild/expression/IntegerValue.java"
cp "$SRC_DIR/c/k.java" "$DEST_DIR/com/algobuild/expression/StringValue.java"
cp "$SRC_DIR/c/l.java" "$DEST_DIR/com/algobuild/expression/Value.java"
cp "$SRC_DIR/c/m.java" "$DEST_DIR/com/algobuild/expression/Variable.java"

# Package UI (a.a)
mkdir -p "$DEST_DIR/com/algobuild/ui"
cp "$SRC_DIR/a/a/a.java" "$DEST_DIR/com/algobuild/ui/AssignDialog.java"

# Package Core (a.c.a)
mkdir -p "$DEST_DIR/com/algobuild/core"
cp "$SRC_DIR/a/c/a/a.java" "$DEST_DIR/com/algobuild/core/Application.java"

# Package IO (a.f)
mkdir -p "$DEST_DIR/com/algobuild/io"
cp "$SRC_DIR/a/f/a.java" "$DEST_DIR/com/algobuild/io/AlgoBuildFileInputStream.java"

# Main
mkdir -p "$DEST_DIR/com/algobuild/main"
cp "$SRC_DIR/AlgoBuildBootLoader.java" "$DEST_DIR/com/algobuild/main/AlgoBuildBootLoader.java"

echo "Struttura creata! File copiati con nomi descrittivi."
echo "Nota: I contenuti interni mantengono i nomi originali decompilati,"
echo "ma la struttura package e i nomi delle classi sono ora leggibili."
