# Description
This is backend service for Teacher Management System.

# Models
| model   | fields       | type         | required |
| teacher | id           | int          | yes      |
| teacher | name         | String       | yes      |
| teacher | gender       | Enum         | yes      |
| teacher | age          | int          | yes      |
| teacher | subject      | List<String> | yes      |
| teacher | school       | String       | yes      |
| teacher | education    | String       | no       |
| teacher | level        | Enum         | no       |
| teacher | serviceYears | int          | no       |
| techer  | baseSalary   | double       | yes      |
| techer  | subjectFee   | double       | yes      |
| teacher | headTeacher  | boolean      | no       |
| techer  | pay          | double       | yes      |
| techer  | role         | Enum         | no       |
| techer  | createdBy    | String       | yes      |
| techer  | creadedOn    | Date         | yes      |
| techer  | updatedBy    | String       | yes      |
| techer  | updatedOn    | Date         | yes      |


| model   | fields    | type   | required |
| lesson | dayOfWeek | Enum   | yes      |
| lesson | subject   | String | yes      |
| lesson | teacher   | String | yes      |
| lesson | Time      | String | yes      |
| lesson | Date      | Date   | yes      |
| lesson | createdBy | String | yes      |
| lesson | creadedOn | Date   | yes      |
| lesson | updatedBy | String | yes      |
| lesson | updatedOn | Date   | yes      |

# Enum
| enum   | values       |
| gender | male, female |

| enum  | values                    |
| level | Junior, Mid-level, Senior |

| enum | values                 |
| role | admin, powerUser, user |

| enum      | values                                      |
| dayOfWeek | Monday,Tuesday, Wednesday, Thursday, Friday |

# List
| subject   |
| Math      |
| Chinese   |
| English   |
| Physics   |
| Chemistry |
| Biology   |
| Polity    |
| History   |
| Geography |
| Art       |
| PE        |
| Music     |

| Time          |
| 7:30 - 8:15   |
| 8:25 - 9:10   |
| 9:20 - 10:05  |
| 10:15 - 11:00 |
| 11:10 - 11:55 |
| 13:30 - 14:15 |
| 14:25 - 15:10 |
| 15:20 - 16:05 |
| 16:15 - 17:00 |


| class           |
| class 1 grade 1 |
| class 2 grade 1 |
| class 1 grade 2 |
| class 2 grade 2 |
| class 1 grade 3 |
| class 2 grade 3 |
| class 1 grade 4 |
| class 2 grade 4 |
| class 1 grade 5 |
| class 2 grade 5 |


# Mapping Matrix
subject to lessonFee mapping:
| subject   | lessonFee |
| Math      | 100        |
| Chinese   | 100        |
| English   | 100        |
| Physics   | 80         |
| Chemistry | 80         |
| Biology   | 80         |
| Polity    | 80         |
| History   | 80         |
| Geography | 80         |
| Art       | 50         |
| PE        | 50         |
| Music     | 50         |

# Modules

## Teacher
1. Display teachers in a table with all the fields display, show optional fields after required ones. Show 'gender' and 'subject' fields as dropdown list allows user to pick up value. Order by name. 
2. Provide 'Register' button on top left, click on Register button will insert a new row on top of table in editing mode, allow user to save teacher with validation applied to required fields. 
3. Provide global search in the same line after 'Register' button, allow user to search by required fields ignore case.
4. Add Action field as last field with inline actions 'Edit' and 'Delete' provided in same line. Creator and admin have access to update and delete a record.
5. Click on Edit button will enable online editing, apply validation to required fields.
6. Click on Delete with popup alert for user to confirm Delete action.  

## Schedule
1. Display lessons in a table with all the fields display, show optional fields after required ones. Show 'dayOfWeek', 'subject' and 'teacher' fields as dropdown list allows user to pick up value. Order by 'dayOfWeek'.
2. Provide 'New' button on top left, click on New button will insert a new row on top of table in editing mode, allow user to save lesson with validation applied to required fields.
3. Provide global search in the same line after Register button, allow user to search by required fields ignore case.
4. Add Action field as last field with inline actions "Edit, Delete" provided in same line. Creator and admin have access to update and delete a record.
5. Click on Edit button will enable online editing, apply validation to required fields.
6. Click on Delete with popup alert for user to confirm Delete action.

## Lesson Fees
1. Display lesson fees in a table with all the fields display, show optional fields after required ones.
2. Provide 'New' button on top left, click on New button will insert a new row on top of table in editing mode, allow user to save lesson fee with validation applied to required fields.
3. Provide filters 'Teacher' and 'Month' in the same row after 'New' button, allow user to filter data ignore case. 
4. Provide global search in the same line after 'Month' filter, allow user to search by required fields ignore case. 
5. Add Action field as last field with inline actions "Edit, Delete" provided in same line. Creator and admin have access to update and delete a record. 
6. Click on Edit button will enable online editing, apply validation to required fields. 
7. Click on Delete with popup alert for user to confirm Delete action.

