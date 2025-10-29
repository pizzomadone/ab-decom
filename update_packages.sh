#!/bin/bash

# Aggiorna package declarations e aggiunge header documentazione

cd /home/user/ab-decom/src

# Funzione per aggiungere commento al file
add_doc_header() {
    local file=$1
    local original_path=$2
    local description=$3

    # Crea header temporaneo
    cat > "${file}.header" << EOF
/*
 * AlgoBuild - Decompiled and Refactored
 *
 * Original location: $original_path
 * Description: $description
 *
 * NOTE: Internal method/variable names (a, b, c, etc.) are kept from decompiled code.
 *       Class names and package structure have been refactored for readability.
 */

EOF

    # Rimuovi il vecchio header decompilato e aggiungi il nuovo
    tail -n +4 "$file" > "${file}.body"
    cat "${file}.header" "${file}.body" > "$file"
    rm "${file}.header" "${file}.body"
}

# JSON Package
for file in com/algobuild/json/*.java; do
    sed -i 's/^package b\.a;$/package com.algobuild.json;/' "$file"
    basename=$(basename "$file" .java)
    add_doc_header "$file" "b/a/${basename:0:1}.java" "JSON library component"
done

# Expression Package
for file in com/algobuild/expression/*.java; do
    sed -i 's/^package c;$/package com.algobuild.expression;/' "$file"
done

# UI Package
for file in com/algobuild/ui/*.java; do
    sed -i 's/^package a\.a;$/package com.algobuild.ui;/' "$file"
done

# Core Package
for file in com/algobuild/core/*.java; do
    sed -i 's/^package a\.c\.a;$/package com.algobuild.core;/' "$file"
done

# IO Package
for file in com/algobuild/io/*.java; do
    sed -i 's/^package a\.f;$/package com.algobuild.io;/' "$file"
done

# Main Package
for file in com/algobuild/main/*.java; do
    sed -i 's/^import a\.c\.a\.a;$/import com.algobuild.core.Application;/' "$file"
    sed -i 's/^\s*$/package com.algobuild.main;\n/' "$file"
done

echo "Package declarations aggiornati e documentazione aggiunta!"
