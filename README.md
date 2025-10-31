# Appliance Management System

## Overview
This Java project implements an **Appliance Management System** with a graphical user interface (GUI) that allows users to manage and sort various household appliances.  
It demonstrates **object-oriented programming principles** such as inheritance, polymorphism, and exception handling, along with **data organization using TreeMaps** and **custom comparators** for sorting.

The GUI enables loading appliance data from files, viewing sorted lists, and managing different appliance types (e.g., Dishwashers, Microwaves, Refrigerators).

---

##  Features
- **Object-Oriented Design**: Uses inheritance and encapsulation across multiple appliance types.  
- **Custom Sorting**: Three different `TreeMap` objects sort appliances by serial number, brand, or cost using `Comparator` classes.  
- **GUI Interface**: Built with `JFrame` and `JMenuBar`, allowing easy interaction with appliance data.  
- **File Input Support**: Reads data from text files and validates input with custom exception handling (`IllegalApplianceException`).  
- **Scalable Design**: Easy to extend by adding new appliance types or comparators.

---

## 🗂️ Project Structure

| File | Description |
|------|--------------|
| **Appliance.java** | Abstract base class containing common attributes (brand, serial number, cost) and shared methods. |
| **Refrigerator.java**, **Microwave.java**, **Dishwasher.java** | Subclasses that extend `Appliance` with unique attributes and overridden methods. |
| **ApplianceManager.java** | Handles reading appliance data, organizing it into TreeMaps, and managing sorting logic. |
| **ApplianceGUI.java** | GUI implementation that displays appliances and includes menu controls for user interaction. |
| **FileMenuHandler.java** | Handles menu actions such as file loading and GUI updates. |
| **SerialNumberComparator.java** | Custom comparator to sort appliances based on serial number. |
| **IllegalApplianceException.java** | Custom exception to handle invalid or missing appliance data. |
| **Project4.java** | The main driver class that launches the GUI and initializes the application. |

---

