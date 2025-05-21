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
| lession | dayOfWeek | Enum   | yes      |
| lession | subject   | String | yes      |
| lession | teacher   | String | yes      |
| lession | Time      | String | yes      |
| lession | Date      | Date   | yes      |
| lession | createdBy | String | yes      |
| lession | creadedOn | Date   | yes      |
| lession | updatedBy | String | yes      |
| lession | updatedOn | Date   | yes      |

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
subject to lessionFee mapping:
| subject   | lessionFee |
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

## Teacher page
1. Display teachers in a table with all the fields display, show optional fields after requried ones. Order by updateOn desc. 
2. Provide Register button on top left, click on Register button will insert a new row on top in editing mode, allow user to save with all requried fields specified. 
3. Provide global search on top left after Register button, allow user to search by required fields ignore case.
4. Creator and admin have access to update and delete.
5. Click on Edit button will enable online editing, apply validation to required fields.
6. Click on Delete with popup alert for user to confirm Delete action.  

## Schedule page
1. Display lessions in a table with all the fields display, show optional fields after requried ones. 
2. Provide global search box on top left, allow user to serach by required fields ignore case.
3. Creator user and admin have access to create, retrieve, update and delete.
4. TODO...

## Lession Fees
1. Display lession fees in a table.
2. Provide filters Teacher and Month on top left as dropdown list. 
3. Provide global search box on top left after filters, allow user to serach by required fields ignore case.
4. Creator user and admin have access to create, retrieve, update and delete.
5. TODO...



