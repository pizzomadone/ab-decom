#!/bin/bash

# Script completo per copiare TUTTI i file nella nuova struttura

SRC="/home/user/ab-decom"
DEST="/home/user/ab-decom/src"

echo "Copiando tutti i file nella nuova struttura..."

# Package a.b -> com.algobuild.ui.components
mkdir -p "$DEST/com/algobuild/ui/components"
cp "$SRC/a/b/"*.java "$DEST/com/algobuild/ui/components/" 2>/dev/null

# Package a.c.a -> com.algobuild.core.application
mkdir -p "$DEST/com/algobuild/core/application"
cp "$SRC/a/c/a/"*.java "$DEST/com/algobuild/core/application/" 2>/dev/null

# Package a.c.b -> com.algobuild.core.blocks
mkdir -p "$DEST/com/algobuild/core/blocks"
cp "$SRC/a/c/b/"*.java "$DEST/com/algobuild/core/blocks/" 2>/dev/null

# Package a.d -> com.algobuild.security
mkdir -p "$DEST/com/algobuild/security"
cp "$SRC/a/d/"*.java "$DEST/com/algobuild/security/" 2>/dev/null

# Package a.e -> com.algobuild.security.base
mkdir -p "$DEST/com/algobuild/security/base"
cp "$SRC/a/e/"*.java "$DEST/com/algobuild/security/base/" 2>/dev/null

# Package a.f -> com.algobuild.io
cp "$SRC/a/f/"*.java "$DEST/com/algobuild/io/" 2>/dev/null

# Package a.g -> com.algobuild.graphics
mkdir -p "$DEST/com/algobuild/graphics"
cp "$SRC/a/g/"*.java "$DEST/com/algobuild/graphics/" 2>/dev/null

# Package a.h -> com.algobuild.utils
mkdir -p "$DEST/com/algobuild/utils"
cp "$SRC/a/h/"*.java "$DEST/com/algobuild/utils/" 2>/dev/null

# Package a.i -> com.algobuild.i18n
mkdir -p "$DEST/com/algobuild/i18n"
cp "$SRC/a/i/"*.java "$DEST/com/algobuild/i18n/" 2>/dev/null

# Package a.j.a -> com.algobuild.editor.core
mkdir -p "$DEST/com/algobuild/editor/core"
cp "$SRC/a/j/a/"*.java "$DEST/com/algobuild/editor/core/" 2>/dev/null

# Package a.j.b -> com.algobuild.editor.ui
mkdir -p "$DEST/com/algobuild/editor/ui"
cp "$SRC/a/j/b/"*.java "$DEST/com/algobuild/editor/ui/" 2>/dev/null

# Package a.k -> com.algobuild.main
cp "$SRC/a/k/"*.java "$DEST/com/algobuild/main/" 2>/dev/null

# Package a.a -> com.algobuild.ui.dialogs (già fatto parzialmente)
cp "$SRC/a/a/"*.java "$DEST/com/algobuild/ui/dialogs" 2>/dev/null || true

# Copia tutti i file rimanenti dal package c
cp "$SRC/c/"*.java "$DEST/com/algobuild/expression/" 2>/dev/null

echo "Aggiornamento package declarations..."

# Aggiorna package declarations
find "$DEST" -name "*.java" -type f | while read file; do
    # Determina il package corretto dal path
    pkg_path=$(dirname "$file" | sed "s|$DEST/||" | tr / .)

    # Sostituisci package declaration
    sed -i "s/^package [a-z]\(\.[a-z]\)*;$/package $pkg_path;/" "$file"
done

echo "Completato! Totale file copiati:"
find "$DEST" -name "*.java" -type f | wc -l
