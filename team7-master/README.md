

Project Name: Adventure Game 

By: Drew Sadler, Andrew Hediger, and Eric Suter 

Overview: Our project is a text adventure game in which the user can input certain commands to interact with the screen, use items in their inventory, and talk to NPC characters. The visible map is sectioned off into smaller tiles that the player can traverse using commands such as “go north”. Encounters with enemies can be engaged by an attack command or in some cases though a scripted event on a specific tile. There are four battle buttons that appear once you engage, including attack, magic, item, and flee. There are different ways to complete the game all depending on your playstyle. You can battle your way through enemies to the final boss, do a string of help quests by slaying enemies for NPCs.

Functional Requirements: FR0: Upon launching the game there is a simple menu with the options of starting a new game and loading a saved game

FR1: At the start of the game the player begins at the starting location on the tiled map. FR1a: Items will be visible on the map that can be interacted with or taken and put into the players inventory.

FR2: The player can choose to move to adjacent tiles by typing in a command FR2a: if the inputted direction is off the map, they will be unable to move.

FR3: When the player goes to a new tile that is pre set to have an enemy the screen would change to a battlefield when the player can engage in combat.

FR4: In a battle the player can choose new commands that are not available outside of combat FR4a: The player can attack where they will deal damage to an enemy FR4b: The player can cast a magic spell to deal damage FR4c: The player can use an item such as a potion to regain hit points FR4d: The player can attempt to flee the battle which has a certain percentage chance to succeed.

FR5: The player can interact with the characters in the town to receive quests, or simply talk.

FR6: The player can check their progress on the two different win conditions by a “progress” command, which shows a percentage of completion for each. In order to save the players data we input the inventory, skills, health, and player position into a file to load. FR6a: The first win condition is all the enemies are killed FR6b: The second win condition is a string of quest between characters

FR7: Once a win condition is met, the player has the option to continue and do the other victories, or to simply finish.


User Interface Requirements:rezi UIR0: The player has the option to enter commands into a text field to interact with the world UIR0a: The player can list all commands by using the "help" command

UIR1: When the user types in a directional command and presses enter, FR2 is executed.

UIR2: When the user clicks the attack screen buttons, their specific action is completed, as shown in FR4

UIR3: When the user types in a use or interact command and presses enter, FR1a and FR6 are executed.

UIR4: When the user types in a progress command and presses enter, FR7 is executed.

UIR5: At the start of the game, the players inventory and quests will be empty, with each only being filled by NPC interaction and use/interact commands.

UIR6: In battle, the new UI will appear with battle options, as well as a view of the enemy you are fighting and both of your health.

UIR7: After clearing a victory condition, FR8 will execute..
