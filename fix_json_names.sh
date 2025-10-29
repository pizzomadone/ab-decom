#!/bin/bash

# Script per rinominare completamente le classi nel package JSON

cd /home/user/ab-decom/src/com/algobuild/json

# Fix JSONArray.java
sed -i \
    -e 's/^public final class a$/public final class JSONArray/' \
    -e 's/\bf f2\b/JSONTokenizer tokenizer/g' \
    -e 's/\bf2\./tokenizer./g' \
    -e 's/\bc\.a\b/JSONObject.NULL/g' \
    -e 's/\bc\.b\b/JSONObject.wrap/g' \
    -e 's/new b(/new JSONException(/g' \
    -e 's/ a\b/ JSONArray/g' \
    JSONArray.java

# Fix JSONObject.java
sed -i \
    -e 's/^public final class c$/public final class JSONObject/' \
    -e 's/\bf f2\b/JSONTokenizer tokenizer/g' \
    -e 's/\bf2\./tokenizer./g' \
    -e 's/new b(/new JSONException(/g' \
    -e 's/new a(/new JSONArray(/g' \
    -e 's/\bpublic static final Object a = new d(0);/public static final Object NULL = new JSONNull((byte)0);/' \
    -e 's/instanceof a\b/instanceof JSONArray/g' \
    -e 's/instanceof c\b/instanceof JSONObject/g' \
    -e 's/instanceof d\b/instanceof JSONNull/g' \
    -e 's/instanceof e\b/instanceof JSONString/g' \
    -e 's/(a)/JSONArray/g' \
    -e 's/(c)/JSONObject/g' \
    -e 's/\ba object\b/JSONArray jsonArray/g' \
    -e 's/\bc object\b/JSONObject jsonObject/g' \
    JSONObject.java

echo "Nomi delle classi JSON corretti!"
