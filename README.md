# rzit-ms-airports 
airports project for expose the apis for intract with airport DB.

Contains general user input logic and validation: airports information and settings.


| Method	      | Path	                  				| Description	  					| User authenticated	| Available from UI|
| ------------- | -------------------------   				| ---------------------------------	|:---------------------:|:----------------:|
| POST	        | /resource/v1/employee	      				| Create specified Employee data	| Yes 					| × 		       | 
| GET	        | /resource/v1/employee/{id}  				| Get specified Employee data		| Yes				    | ×				   |
| DELETE	    | /resource/v1/employee/{id}  				| Delete specified Employee data	| Yes                   | ×                |
| PUT	        | /resource/v1/employee/{id}  				| Update current employee data		| Yes                   | ×                |
| POST	        | /resource/v1/employee/upload 				| Upload Employer by CSV file 		| Yes                   | ×                |
| POST	        | /resource/v1/employee/identify-duplicate	| Identify unique employees 		| Yes                   | ×                |
