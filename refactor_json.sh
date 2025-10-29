#!/bin/bash

# Script per refactoring automatico del package JSON
# Copia i file e sostituisce i nomi delle classi

cd /home/user/ab-decom

# Copia JSONArray
cp b/a/a.java src/com/algobuild/json/JSONArray.java

# Copia JSONObject
cp b/a/c.java src/com/algobuild/json/JSONObject.java

echo "File copiati. Ora sostituisco i riferimenti..."

# Sostituisci package declaration
sed -i 's/^package b\.a;$/package com.algobuild.json;/' src/com/algobuild/json/JSONArray.java
sed -i 's/^package b\.a;$/package com.algobuild.json;/' src/com/algobuild/json/JSONObject.java

# Sostituisci import statements
find src/com/algobuild/json -name "*.java" -type f -exec sed -i \
    -e 's/import b\.a\.a;/import com.algobuild.json.JSONArray;/g' \
    -e 's/import b\.a\.b;/import com.algobuild.json.JSONException;/g' \
    -e 's/import b\.a\.c;/import com.algobuild.json.JSONObject;/g' \
    -e 's/import b\.a\.d;/import com.algobuild.json.JSONNull;/g' \
    -e 's/import b\.a\.e;/import com.algobuild.json.JSONString;/g' \
    -e 's/import b\.a\.f;/import com.algobuild.json.JSONTokenizer;/g' \
    {} \;

# Sostituisci class references (questo è più complicato e va fatto con attenzione)
find src/com/algobuild/json -name "*.java" -type f -exec sed -i \
    -e 's/\bb\.a\.a\b/JSONArray/g' \
    -e 's/\bb\.a\.b\b/JSONException/g' \
    -e 's/\bb\.a\.c\b/JSONObject/g' \
    -e 's/\bb\.a\.d\b/JSONNull/g' \
    -e 's/\bb\.a\.e\b/JSONString/g' \
    -e 's/\bb\.a\.f\b/JSONTokenizer/g' \
    {} \;

echo "Refactoring del package JSON completato!"
