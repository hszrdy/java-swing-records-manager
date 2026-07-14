# Person Records Manager (Java Swing)

A desktop GUI application for managing a list of people's records - name, birthday, and auto-calculated age built with **Java Swing** and NetBeans/Ant.

## Features

- **Login screen** with username/password authentication (checked against `loginCredentials.txt`) and a 3-attempt lockout
- **Add records** - enter a name and pick a birthdate (mm/dd/yyyy dropdowns). Age is calculated automatically
- **Remove records** - remove an existing entry by name
- **Sort records** by Name, Birthday, or Age (ascending/descending)
- **Export to CSV** - save the current record list to a timestamped `.csv` file

## Requirements

- Java JDK 8+
- NetBeans

### Running the app

1. Clone the repo:
   ```bash
   git clone https://github.com/hszrdy/<repo-name>.git
   ```
2. Open the project in NetBeans, or build with Ant:
   ```bash
   ant run
   ```
3. Log in using one of the credentials in `loginCredentials.txt` (e.g. `user1` / `pass1`).

## Project Structure

```
src/mp5/
   - Main.java                    # Entry point, wires up login and records views
   - LoginView.java                # Login UI
   - LoginController.java          # Login logic / attempt tracking
   - Credentials.java               # Credential validation
   - CentralRecordsView.java       # Main records table UI
   - RecordsController.java        # Add/remove/export/sort logic
   - RecordsModifierViewBase.java  # Shared base UI for add/remove forms
   - AddRecordsView.java           # Add-record form
   - RemoveRecordsView.java        # Remove-record form
   - Person.java                    # Data model (name, birthday, age)
   - Utilities.java                 # File I/O helpers (credentials, CSV, month mapping)
```

## Notes

- Records are stored in memory only for the current session. Use _Export to CSV_ feature to save them, since there is no persistent database.
- `loginCredentials.txt` stores credentials in plaintext, this is a learning project and not intended for production use.
