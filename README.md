# To-Do Application

## Introduction

This repository contains a simple To-Do application designed to help you manage your tasks efficiently. The application includes `todo.bat` and `todo.class` files. Follow the instructions below to set up and use the application on your system.

## Setup

### Option 1: Moving Files to `C:\Windows\System32\`
If you have access to `C:\Windows\System32\`, follow these steps:

1. Locate the `todo.bat` and `todo.class` files in this repository.
2. Move both files to `C:\Windows\System32\`.

### Option 2: Creating a Package
If you don't have access to `C:\Windows\System32\`, follow these steps to create a package and add it to the `PATH` environmental variable:

1. Create a new directory to serve as a package for your To-Do application.
2. Move the `todo.bat` and `todo.class` files into this new directory.
3. Add the path to this directory to the system's `PATH` environmental variable.

#### Updating Environmental Variables
- **Windows**:
    - Open Control Panel.
    - Navigate to System and Security > System.
    - Click on "Advanced system settings" on the left sidebar.
    - In the System Properties window, click on the "Environment Variables..." button.
    - Under System Variables, find the `PATH` variable and click Edit.
    - Add the path to your To-Do application directory to the `PATH` variable. Separate paths with a semicolon if necessary.
    - Click OK in all windows to apply the changes.
- **Linux/Unix**:
    - Open a terminal.
    - Edit the `.bashrc` or `.bash_profile` file in your home directory:
        ```bash
        nano ~/.bashrc
        ```
    - Add the following line at the end of the file, replacing `/path/to/your/directory` with the actual path:
        ```bash
        export PATH=$PATH:/path/to/your/directory
        ```
    - Save and close the file. Then, reload the shell:
        ```bash
        source ~/.bashrc
        ```

## Functions

- **-a -m**: Add a message to the end of the list.
    - Example: `todo -a -m do something funny`
- **-a 'num -m**: Add a message at position 'num.
    - Example: `todo -a 3 -m make coffee`
- **-r 'num**: Remove a message at position 'num.
    - Example: `todo -r 7`
- **-l**: List all messages.
- **-c**: Clear the entire list.

Note: `'num` represents the index to be operated on. It should be greater than or equal to zero and less than the total number of activities.

## Getting Started

1. Clone the repository to your local machine.
2. Navigate to the project directory.
3. Compile the source code.
4. Execute the compiled program.
5. Follow the usage instructions provided above to manage your tasks effectively.

## Contributing

Contributions are welcomed via pull requests. For major changes, please open an issue first to discuss the proposed adjustments.
