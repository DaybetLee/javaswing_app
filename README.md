# My School Assignment 1</h1>

This is my first application source code for my school assignment.
It is coded in Java on NetBeans IDE 8.2.

Here are the requirements:

Lee Brother Travel Company is a local travel agency specializing in arranging Japan tour packages for clients.
The pricing will depend on the selected region, season, flight, hotel, food and tour guide. Below is a guide to the various parameters.
The list of regions and their base prices per person are as follow:

<ol>
  <li>Tokyo ($400)</li>
  <li>Osaka ($450)</li>
  <li>Fukuoka ($500)</li>
  <li>Okinawa ($550)</li>
  <li>Hokkaido ($600) </li>
</ol> 

The following are the four seasons and the periods in Japan. Prices of flight and hotel vary according to the season.

<ul>
  <li>Spring: March to May</li>
  <li>Summer: June to August</li>
  <li>Autumn: September to November</li>
  <li>Winter: December to February</li>
</ul>

<table style="width:100%">
  <tr>
    <th>Seasons</th>
    <th>Period</th>
    <th>Flight</th>
    <th>Hotel</th>
  </tr>
  <tr>
    <td>Spring</td>
    <td>March to May</td>
    <td>Base price x 1.3</td>
    <td>Base price x 1.3</td>
  </tr>
  <tr>
    <td>Summer</td>
    <td>June to August </td>
    <td>Base price x 1.5</td>
    <td>Base price x 1.2</td>
  </tr>
  <tr>
    <td>Autumn</td>
    <td>September to November</td>
    <td>Base price x 1.2</td>
    <td>Base price x 1.4</td>
  </tr>
  <tr>
    <td>Winter</td>
    <td>December to February</td>
    <td>Base price x 1.4</td>
    <td>Base price x 1.1</td>
  </tr>
</table>

<ul>
<li>Note: hotel charges will be based on single, double or triple. For double and triple the hotel cost as shown above divide by 2.</li>
</ul>

The following are the prices for two categories of food for lunch and dinner. Breakfast is included in the hotel booking.

<ul>
<li>High: Lunch is $50/person, Dinner is $90/person</li>
<li>Average: Lunch is $15/person, Dinner is $25/person</li>
</ul>

The prices for tour guide are as follow.

<ul>
<li>$120 per day per group of 1 to 10 persons</li>
<li>$200 per day per group of 11 to 30 persons</li>
<li>Each tour guide can only handle maximum of 30 persons. That is if a group of 31 persons will need 2 tour guide.</li>
</ul>

From this information, build an online booking system to calculate the cost of the tour per group and per person.
User interface should be a GUI (graphical user interface) using AWT/Swing.
