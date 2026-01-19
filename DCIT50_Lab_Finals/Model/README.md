Holds all the classes that define tasks and their properties.

AbstractTask.java
 - Abstract parent class for all tasks. Stores basic info like ID, name, and description. Requires subclasses to implement status methods.

Task.java
 - Extends AbstractTask. Adds a status attribute (Not Started, Ongoing, Done) and implements status methods. This is the main type of task used.

TimedTask.java
 - Extends Task. Adds an estimatedTime (in minutes) for tasks that need a time estimate. Uses proper encapsulation.

