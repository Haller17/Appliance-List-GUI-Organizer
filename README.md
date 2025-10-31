# Appliance Management System

## Overview
This Java project implements an **Appliance Management System** with a graphical user interface (GUI) that allows users to manage and sort various household appliances.  
It demonstrates **object-oriented programming principles** such as inheritance, polymorphism, and exception handling, along with **data organization using TreeMaps** and **custom comparators** for sorting.

The GUI enables loading appliance data from files, viewing sorted lists, and managing different appliance types (e.g., Dishwashers, Microwaves, Refrigerators).

---

- **Object-Oriented Design** – Each appliance type (like Refrigerator, Microwave, or Dishwasher) extends a shared base class with its own unique behavior and fields.  
- **Sorting** – Appliances are stored in multiple `TreeMap` structures and sorted by serial number, brand, or cost using custom `Comparator` classes.  
- **User-Friendly GUI** – A Swing interface makes it easy to open files, display data, and view sorted appliances.  
- **File Input with Error Handling** – Reads appliance info from text files and uses a custom exception class to catch invalid or incomplete data.  
- **Flexability** – This structure makes it simple to add new appliance types or sorting rules later on.

## Project Structure

| File | Description |
|------|--------------|
| **Appliance.java** | Abstract base class containing common attributes (brand, serial number, cost) and shared methods. |
| **Refrigerator.java**, **Microwave.java**, **Dishwasher.java** | Subclasses that extend `Appliance` with unique attributes and overridden methods. |
| **ApplianceManager.java** | Handles reading appliance data, organizing it into TreeMaps, and managing sorting logic. |
| **ApplianceGUI.java** | GUI implementation that displays appliances and includes menu controls for user interaction. |
| **FileMenuHandler.java** | Handles menu actions such as file loading and GUI updates. |
| **SerialNumberComparator.java** | Custom comparator to sort appliances based on serial number. |
| **IllegalApplianceException.java** | Custom exception to handle invalid or missing appliance data. |
| **Main.java** | The main driver class that launches the GUI and initializes the application. |

---

