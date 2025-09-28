# PlayerVersusMonsters

**Telegram:** @lefeeo

## Description

This is a simple console-based game implemented in Kotlin, where a Player fights a Monster in a turn-based combat system. The game demonstrates object-oriented programming principles, including inheritance and encapsulation.

## Features

- Classes for Creatures, Player, and Monster with attack, defense, health, and damage range attributes.
- Attack success determined by dice roll mechanics with modifiers based on attacker’s attack and defender’s defense.
- Player can heal up to 4 times per game, restoring 30% of max health.
- Turn-based game loop with user choices: attack, heal, skip turn, or exit.
- Input validation and handling of invalid inputs.
- Clear game status updates and end-of-game result messages.

## How to Run

1. Make sure you have JDK 11 or higher installed.
2. Clone or download the repository.
3. Open the project in an IDE supporting Kotlin (IntelliJ IDEA recommended).
4. Run the main function in the `Main.kt` file.
5. Follow the console prompts to play the game.

## Usage

- At main menu, select:
  - `1` to start a new game,
  - `2` to exit.

- In game, choose:
  - `1` to attack the monster,
  - `2` to heal yourself (max 4 times),
  - `3` to skip your turn,
  - `4` to quit (with option to return to main menu or exit game).

- The monster automatically attacks after the player's turn.
- The game ends when either the player or the monster's health reaches zero.

## Design Details

- All entities are designed in OOP style with validation against invalid parameters.
- Attack success uses a number of dice equal to the attack modifier, with success if any dice shows 5 or 6.
- Damage dealt is randomly chosen within the attacker’s damage range.
- Health management ensures a creature cannot have negative health.
- Player healing is limited as per requirements.

## Contact

For questions or discussion about the project, contact me on Telegram: @lefeeo
