# ParkingGarage
Parking Garage Management App

ParkingGarage app creates at Lot after the user enters the length and width dimensions of the given area. The area is 
divided into three parking categories: Car, Truck, and Motorcycle.  Priority is given to Car parking spaces as space 
permits.

During creation, Parking Spaces are inserted into an ArrayList (one for each variety of space).  Each space is assigned an
integer value noting its distance to the garage exit.  The arraylists are then sorted using a custom Comparable and pushed 
into their respective stack in reverse order.

Garage attendants are created by an administrator and stored in a HashMap for fast lookup.  

As vehicles enter the garage, each vehicle is assigned the closest available parking space according to distance to exit.  That 
space is popped from its respective stack. Vehicles are stored in a HashMap using their license plate numbers as keys for quick lookup.  
When a vehicle object is created, the specific time of its drop off is stored as Date object, along with the rate depending on drop off 
time and the attendant who parked the vehicle.

A ticket textfile is then produced detailing drop off time, attendant, rate, license number, and parking space.  

During check out, a receipt is produced with the above details and checkout time.  The TicketManager class calculates
the total amount of time in hours the vehicle was parked and how much the owner owes at checkout.  The respective Parking
Space for that vehicle is then pushed back into its respective stack.  
