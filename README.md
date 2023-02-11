# ProcessorExecutionSimulator

This is Java program used to simulate the execution of tasks in a multi-processor system.
The simulation uses a priority-based scheduling algorithm to assign tasks to processors and simulates the execution of each task over time.
The simulation outputs a report showing the state of each processor at each clock cycle.

## Requirements
To run the simulation, you will need:

Java 8 or higher
IntelliJ IDEA or any other Java development environment

## Usage
Clone the repository to your local machine using the following command:
```
git clone https://github.com/yazn94/ProcessorExecutionSimulator.git
```
or from Intellij itself. 

you can run the jar file from your terminal inside of your IDE, using this command: 
```
 java -jar .\out\artifacts\ProcessorExecutionSimulator_jar\ProcessorExecutionSimulator.jar
```
## Running
The program will prompt you to enter the path of the input file. 

The input file should contain the following information:
The number of processors in the system (int) 

The total number of clock cycles in the simulation (int) 

The number of tasks (int) 

The creation time, execution time, and priority of each task (for each task) 

The simulation will then run and output the state of each processor at each clock cycle, and it will give the final report about the whole process. 

Alternatively, you might use one of the files inside of the InputFiles package.
```
src/InputFiles/input3.txt
