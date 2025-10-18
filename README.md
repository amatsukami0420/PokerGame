# Cards

A simple Java project that models a standard deck of playing cards, deals a 5‑card hand, and evaluates the hand (e.g., Pair, Two Pair, Straight, Flush, Full House, Four of a Kind, Straight Flush).

The project contains three classes:
- Card: immutable value object for a playing card (face and suit).
- Deck: builds and shuffles a 52‑card deck, deals a hand, and evaluates poker hands.
- TestDeck: minimal entry point with a main method to demo dealing and evaluating a hand.

## Technology Stack
- Language: Java (plain Java project)
- Frameworks/Libraries: none
- Build tool/package manager: none (no Maven/Gradle wrappers in repo)

## Requirements
- Java Development Kit (JDK) 8 or newer installed and on your PATH
  - TODO: Confirm the exact target Java version used to compile (`out/` contains .class files but version not specified).
- A terminal that can display Unicode card suits (♠️ ♦️ ♣️ ♥️). On Windows, use Windows Terminal or ensure your console font supports these glyphs.

## Project Structure
```
Cards/                     # project root
├─ src/
│  ├─ Card.java            # Card model (face, suit, toString)
│  ├─ Deck.java            # Deck creation, shuffle, deal, evaluate hand
│  └─ TestDeck.java        # Main entry point for demo
├─ out/                    # compiled classes (generated locally, safe to delete)
│  └─ production/...
├─ Cards.iml               # IntelliJ IDEA module file
└─ README.md               # this file
```

## How to Build and Run
This is a simple source‑only project. You can compile and run it using the JDK tools from the project root.

Windows PowerShell (current repo uses Windows paths):

1) Compile to an `out` directory
```
javac -d out src\*.java
```

2) Run the demo entry point
```
java -cp out TestDeck
```

If your console prints question marks for suits, force UTF‑8 when running:
```
java -Dfile.encoding=UTF-8 -cp out TestDeck
```

### Running in IntelliJ IDEA (optional)
- Open the project directory (Cards) in IntelliJ.
- Mark `src` as Sources Root if not already.
- Right‑click `TestDeck.main` and Run.

## Scripts
There are no repo‑defined scripts. Suggested convenience commands for Windows PowerShell:
- Build: `javac -d out src\*.java`
- Run: `java -cp out TestDeck`

If you add a build tool later (e.g., Maven or Gradle), update this section accordingly.

## Configuration and Environment Variables
- None required.
- TODO: Document any future configuration (e.g., random seed control for deterministic runs).

## Tests
There is no unit test framework configured. `TestDeck` acts as a simple smoke test by:
- Creating a `Deck`
- Dealing a 5‑card hand
- Printing the hand and its evaluation

To "test" manually:
```
javac -d out src\*.java
java -cp out TestDeck
```

If you plan to add automated tests:
- TODO: Choose a test framework (JUnit 5 recommended) and add instructions (e.g., via Maven/Gradle) or keep plain `javac/java` commands.

## Entry Points
- `TestDeck.main(String[] args)` — demo entry point.

## Known Limitations
- Ace is treated as high (value 14); low‑Ace straights (A‑2‑3‑4‑5) are not supported.
- No command‑line arguments; hand size is fixed at 5.
- No persistence or UI.

## License
No license file was found in the repository.
- TODO: Add a LICENSE file (e.g., MIT, Apache‑2.0, or as appropriate) and update this section.

## Attribution
- Suits are printed as Unicode characters: ♠️ ♦️ ♣️ ♥️.
