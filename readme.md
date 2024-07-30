# Fetch Coding Exercise
#### Table of Contents
1. [Overview](#overview)
2. [Algorithm Explanation](#algorithm-explanation)
3. [Setup and Installation](#setup-and-installation)
4. [Running the Program](#running-the-program)
5. [Dependencies](#dependencies)
6. [Author](#author)

## Overview
This repository contains the solution to the Fetch coding exercise for the SDET position. The goal is to find the fake gold bar among 9 bars using the minimum number of weighings. The solution is implemented in Java using Selenium for web automation.

## Algorithm Explanation
The algorithm used to find the fake gold bar with the minimum number of weighings is based on the divide-and-conquer method:

1. **Divide the Bars into Groups**:
    - We start with 9 gold bars and divide them into three groups of three bars each.

2. **First Weighing**:
    - Weigh the first group against the second group.
    - If they balance, the fake bar is in the third group.
    - If they do not balance, the lighter group contains the fake bar.

3. **Second Weighing**:
    - Take the lighter group of 3 bars and weigh two of them.
    - If they balance, the third one is the fake bar.
    - If they do not balance, the lighter one is the fake bar.

This method ensures that we can find the fake bar in just two weighings.

## Setup and Installation

### Prerequisites
- Java Development Kit (JDK) installed.
- Maven installed.
- Chrome browser installed.
- Install IntelliJ IDEA

**Clone the Repository**:

    git clone git@github.com:navneetsandha/FetchAssignment.git
    

## Running the Program

1. **Open the Project in IntelliJ IDEA**:

- Launch IntelliJ IDEA.
- Go to File > Open (or press Ctrl+O on Windows/Linux, Cmd+O on macOS).
- Navigate to the directory containing your FetchAssignment project files.
- Select the project folder and click Open.
  
2. **Run the Tests**:

- In the Project tool window, locate the Tests.java file within the FetchAssignment project.
- Right-click on the Tests.java file.
- From the context menu, select Run Tests in 'Tests.java' (or a similar option depending on your IntelliJ IDEA version).
- IntelliJ IDEA will execute the TestNG tests defined in the Tests.java file.
  
3 **You should see the following behavior**:

- The program opens the website http://sdetchallenge.fetch.com/. 
- The program simulates the weighings of the gold bars. 
- The program identifies the fake gold bar based on the weight discrepancies. 
- The program prints the results

## Dependencies

- Java Development Kit (JDK)
- Selenium Java bindings
- Chrome browser

## Author
- **Navneet Sandha**
Feel free to reach out to me at [navneetsandha19@gmail.com](mailto:navneetsandha19@gmail.com) for any questions or further information.
