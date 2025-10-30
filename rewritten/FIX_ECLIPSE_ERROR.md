# 🔧 Fix Errore Compilazione Eclipse

## ❌ Errore che hai ricevuto:
```
Exception in thread "main" java.lang.Error: Unresolved compilation problem:
	at rewritten.algobuild.test.AlgorithmTest.main(AlgorithmTest.java:12)
```

---

## 🎯 CAUSA DEL PROBLEMA

Hai copiato la cartella **SBAGLIATA** in Eclipse!

### ❌ Cosa hai fatto (SBAGLIATO):
```
Copiato:  /home/user/ab-decom/rewritten/
Risultato in Eclipse:  src/rewritten/algobuild/...
Package atteso:        rewritten.algobuild.test
Package dichiarato:    algobuild.test  ← MISMATCH!
```

### ✅ Cosa devi fare (CORRETTO):
```
Copiare:  /home/user/ab-decom/rewritten/algobuild/
Risultato in Eclipse:  src/algobuild/...
Package atteso:        algobuild.test
Package dichiarato:    algobuild.test  ← MATCH!
```

---

## 🛠️ SOLUZIONE - Passo per Passo

### Step 1: Cancella quello che hai copiato
In Eclipse:
1. Vai nel Package Explorer
2. Trova la cartella `rewritten` dentro `src/`
3. Click destro → Delete
4. Conferma

### Step 2: Apri il File Manager
1. Naviga a: `/home/user/ab-decom/rewritten/`
2. Vedrai questa struttura:
   ```
   rewritten/
   ├── algobuild/          ← QUESTA è la cartella da copiare!
   │   ├── model/
   │   ├── parser/
   │   ├── executor/
   │   ├── ui/
   │   └── test/
   ├── README.md
   └── ...
   ```

### Step 3: Copia la cartella GIUSTA
1. **Entra dentro** `/home/user/ab-decom/rewritten/`
2. **Seleziona SOLO** la cartella `algobuild/` (NON `rewritten/`)
3. Click destro → Copy (o Ctrl+C)

### Step 4: Incolla in Eclipse
1. Torna in Eclipse
2. Nel Package Explorer, click destro sulla cartella `src/`
3. Paste (o Ctrl+V)
4. Ora dovresti vedere:
   ```
   TuoProgetto/
   └── src/
       └── algobuild/          ← Corretto!
           ├── model/
           ├── parser/
           ├── executor/
           ├── ui/
           └── test/
   ```

### Step 5: Refresh Eclipse
1. Click destro sul progetto → Refresh (o premi F5)
2. Aspetta che Eclipse ricompili tutto

### Step 6: Verifica che sia corretto
Nel Package Explorer dovresti vedere:
```
📦 algobuild.model
📦 algobuild.parser
📦 algobuild.executor
📦 algobuild.ui
📦 algobuild.test
```

**NON** dovresti vedere:
```
❌ rewritten.algobuild.model
❌ rewritten.algobuild.parser
```

---

## ▶️ ESEGUI L'APPLICAZIONE

### Metodo 1: Esegui il Main
1. Apri `algobuild.ui.AlgoBuildApp.java`
2. Click destro → Run As → Java Application
3. Dovrebbe aprirsi la finestra grafica di AlgoBuild!

### Metodo 2: Esegui i Test (opzionale)
1. Apri `algobuild.test.AlgorithmTest.java`
2. Click destro → Run As → Java Application
3. Nella console dovresti vedere:
   ```
   === AlgoBuild Test Suite ===

   TEST 1: Simple Calculation     ✓ PASSED
   TEST 2: IF Statement           ✓ PASSED
   TEST 3: WHILE Loop             ✓ PASSED
   TEST 4: FOR Loop               ✓ PASSED

   === All tests passed! ===
   ```

---

## 🚨 Se hai ancora errori

### Errore: "package algobuild.model does not exist"
**Soluzione**: Hai copiato file singoli invece della cartella. Ricomincia dallo Step 1.

### Errore: "The declared package does not match the expected package"
**Soluzione**: La struttura delle cartelle è sbagliata. Assicurati di avere `src/algobuild/` e non `src/rewritten/algobuild/`.

### L'applicazione non si avvia
**Verifica**:
1. Che tu abbia Java 8 o superiore
2. Che non ci siano errori di compilazione in Eclipse (icone rosse)
3. Che tu stia eseguendo `AlgoBuildApp.java` e non `AlgorithmTest.java`

---

## ✅ CHECKLIST FINALE

Prima di eseguire, verifica:

- [ ] Ho cancellato la cartella `rewritten` da `src/`
- [ ] Ho copiato SOLO `algobuild/` (non `rewritten/`)
- [ ] In Eclipse vedo `src/algobuild/` (non `src/rewritten/`)
- [ ] Ho fatto Refresh (F5) in Eclipse
- [ ] Non ci sono errori rossi nel Package Explorer
- [ ] Posso vedere i package: algobuild.model, algobuild.parser, etc.

Se tutti i punti sono ✓, allora:

**Run → algobuild.ui.AlgoBuildApp**

E vedrai la finestra grafica di AlgoBuild! 🎉

---

## 📁 Struttura Corretta Finale

```
TuoProgettoEclipse/
├── src/
│   └── algobuild/                    ← Livello root package
│       ├── model/
│       │   ├── Algorithm.java
│       │   ├── Block.java
│       │   ├── AssignBlock.java
│       │   ├── InputBlock.java
│       │   ├── OutputBlock.java
│       │   ├── IfBlock.java
│       │   ├── WhileBlock.java
│       │   ├── ForBlock.java
│       │   └── ExecutionContext.java
│       ├── parser/
│       │   └── ExpressionEvaluator.java
│       ├── executor/
│       │   └── AlgorithmExecutor.java
│       ├── ui/
│       │   └── AlgoBuildApp.java     ← MAIN CLASS
│       └── test/
│           └── AlgorithmTest.java
└── bin/                              (generato automaticamente)
```

---

**Ultima cosa**: Se tutto funziona, vedrai una finestra con:
- Menu in alto (File, Edit, Run, Help)
- Toolbar con icone
- Palette blocchi a sinistra (Assegnazione, Input, Output, IF, While, For)
- Area editor al centro
- Pannello output in basso

Buon coding! 🚀
