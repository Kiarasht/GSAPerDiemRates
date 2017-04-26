package com.restart.perdiem.data;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PlaceManager {
    public static final HashMap<String, List<String[]>> STATE_CITY_MAPPER = new HashMap<>();
    public static final List<String> STATES = new ArrayList<>();

    static {
        setupStates();
        setupCities();
    }

    private static void setupStates() {
        STATES.add("Alabama");
        STATES.add("Alaska");
        STATES.add("American Samoa");
        STATES.add("Arizona");
        STATES.add("Arkansas");
        STATES.add("California");
        STATES.add("Colorado");
        STATES.add("Connecticut");
        STATES.add("Delaware");
        STATES.add("District of Columbia");
        STATES.add("Florida");
        STATES.add("Georgia");
        STATES.add("Guam");
        STATES.add("Hawaii");
        STATES.add("Idaho");
        STATES.add("Illinois");
        STATES.add("Indiana");
        STATES.add("Iowa");
        STATES.add("Kansas");
        STATES.add("Kentucky");
        STATES.add("Louisiana");
        STATES.add("Maine");
        STATES.add("Maryland");
        STATES.add("Massachusetts");
        STATES.add("Michigan");
        STATES.add("Minnesota");
        STATES.add("Mississippi");
        STATES.add("Missouri");
        STATES.add("Montana");
        STATES.add("Nebraska");
        STATES.add("Nevada");
        STATES.add("New Hampshire");
        STATES.add("New Jersey");
        STATES.add("New Mexico");
        STATES.add("New York");
        STATES.add("North Carolina");
        STATES.add("North Dakota");
        STATES.add("Ohio");
        STATES.add("Oklahoma");
        STATES.add("Oregon");
        STATES.add("Pennsylvania");
        STATES.add("Puerto Rico");
        STATES.add("Rhode Island");
        STATES.add("South Carolina");
        STATES.add("South Dakota");
        STATES.add("Tennessee");
        STATES.add("Texas");
        STATES.add("Utah");
        STATES.add("Vermont");
        STATES.add("Virginia Islands");
        STATES.add("Virginia");
        STATES.add("Washington");
        STATES.add("West Virginia");
        STATES.add("Wisconsin");
        STATES.add("Wyoming");
    }

    private static void setupCities() {
        String[] standard = new String[]{"Standard Rate", "Applies for all locations without specified rates"};

        /*  Alabama */
        List<String[]> cities = new ArrayList<>();
        cities.add(standard);
        cities.add(new String[]{"Birmingham", "Jefferson / Shelby"});
        cities.add(new String[]{"Gulf Shores", "Baldwin"});
        cities.add(new String[]{"Mobile", "Mobile"});
        STATE_CITY_MAPPER.put("Alabama", cities);
        cities = new ArrayList<>();

        /* Alaska */
        STATE_CITY_MAPPER.put("Alaska", null);

        /* American Samoa */
        STATE_CITY_MAPPER.put("American Samoa", null);

        /* Arizona */
        cities.add(standard);
        cities.add(new String[]{"Grand Canyon / Flagstaff", "Coconino / Yavapai less the city of Sedona"});
        cities.add(new String[]{"Kayenta", "Navajo"});
        cities.add(new String[]{"Phoenix / Scottsdale", "Maricopa"});
        cities.add(new String[]{"Sedona", "City Limits of Sedona"});
        cities.add(new String[]{"Tucson", "Pima"});
        STATE_CITY_MAPPER.put("Arizona", cities);
        cities = new ArrayList<>();

        /* Arkansas */
        cities.add(standard);
        cities.add(new String[]{"Hot Springs", "Garland"});
        cities.add(new String[]{"Little Rock", "Pulaski"});
        STATE_CITY_MAPPER.put("Arkansas", cities);
        cities = new ArrayList<>();

        /* California */
        cities.add(standard);
        cities.add(new String[]{"Antioch / Brentwood / Concord", "Contra Costa"});
        cities.add(new String[]{"Bakersfield / Ridgecrest", "Kern"});
        cities.add(new String[]{"Barstow / Ontario / Victorville", "San Bernardino"});
        cities.add(new String[]{"Death Valley", "Inyo"});
        cities.add(new String[]{"Eureka / Arcata / McKinleyville", "Humboldt"});
        cities.add(new String[]{"Fresno", "Fresno"});
        cities.add(new String[]{"Los Angeles", "Los Angeles / Orange / Ventura / Edwards AFB less the city of Santa Monica"});
        cities.add(new String[]{"Mammoth Lakes", "Mono"});
        cities.add(new String[]{"Mill Valley / San Rafael / Novato", "Marin"});
        cities.add(new String[]{"Monterey", "Monterey"});
        cities.add(new String[]{"Napa", "Napa"});
        cities.add(new String[]{"Oakhurst", "Madera"});
        cities.add(new String[]{"Oakland", "Alameda"});
        cities.add(new String[]{"Palm Springs", "Riverside"});
        cities.add(new String[]{"Point Arena / Gualala", "Mendocino"});
        cities.add(new String[]{"Redding", "Shasta"});
        cities.add(new String[]{"Sacramento", "Sacramento"});
        cities.add(new String[]{"San Diego", "San Diego"});
        cities.add(new String[]{"San Francisco", "San Francisco"});
        cities.add(new String[]{"San Luis Obispo", "San Luis Obispo"});
        cities.add(new String[]{"San Mateo / Foster City / Belmont", "San Mateo"});
        cities.add(new String[]{"Santa Barbara", "Santa Barbara"});
        cities.add(new String[]{"Santa Cruz", "Santa Cruz"});
        cities.add(new String[]{"Santa Monica", "City limits of Santa Monica"});
        cities.add(new String[]{"Santa Rosa", "Sonoma"});
        cities.add(new String[]{"South Lake Tahoe", "El Dorado"});
        cities.add(new String[]{"Stockton", "San Joaquin"});
        cities.add(new String[]{"Sunnyvale / Palo Alto / San Jose", "Santa Clara"});
        cities.add(new String[]{"Tahoe City", "Placer"});
        cities.add(new String[]{"Truckee", "Nevada"});
        cities.add(new String[]{"Visalia / Lemoore", "Tulare / Kings"});
        cities.add(new String[]{"West Sacramento / Davis", "Yolo"});
        cities.add(new String[]{"Yosemite National Park", "Mariposa"});
        STATE_CITY_MAPPER.put("California", cities);
        cities = new ArrayList<>();

        /* Colorado */
        cities.add(standard);
        cities.add(new String[]{"Aspen", "Pitkin"});
        cities.add(new String[]{"Boulder / Broomfield", "Boulder / Broomfield"});
        cities.add(new String[]{"Colorado Springs", "El Paso"});
        cities.add(new String[]{"Cortez", "Montezuma"});
        cities.add(new String[]{"Crested Butte / Gunnison", "Gunnison"});
        cities.add(new String[]{"Denver / Aurora", "Denver / Adams / Arapahoe / Jefferson"});
        cities.add(new String[]{"Douglas", "Douglas"});
        cities.add(new String[]{"Durango", "La Plata"});
        cities.add(new String[]{"Fort Collins / Loveland", "Larimer"});
        cities.add(new String[]{"Grand Lake", "Grand"});
        cities.add(new String[]{"Montrose", "Montrose"});
        cities.add(new String[]{"Silverthorne / Breckenridge", "Summit"});
        cities.add(new String[]{"Steamboat Springs", "Routt"});
        cities.add(new String[]{"Telluride", "San Miguel"});
        cities.add(new String[]{"Vail", "Eagle"});
        STATE_CITY_MAPPER.put("Colorado", cities);
        cities = new ArrayList<>();

        /* Connecticut */
        cities.add(standard);
        cities.add(new String[]{"Bridgeport / Danbury", "Fairfield"});
        cities.add(new String[]{"Cromwell / Old Saybrook", "Middlesex"});
        cities.add(new String[]{"Hartford", "Hartford"});
        cities.add(new String[]{"New Haven", "New Haven"});
        cities.add(new String[]{"New London / Groton", "New London"});
        STATE_CITY_MAPPER.put("Connecticut", cities);
        cities = new ArrayList<>();

        /* Delaware */
        cities.add(standard);
        cities.add(new String[]{"Dover", "Kent"});
        cities.add(new String[]{"Lewes", "Sussex"});
        cities.add(new String[]{"Wilmington", "New Castle"});
        STATE_CITY_MAPPER.put("Connecticut", cities);
        cities = new ArrayList<>();

        /* District of Columbia */
        cities.add(standard);
        cities.add(new String[]{"District of Columbia", "Washington DC (also the cities of Alexandria, Falls Church and Fairfax, and the counties of Arlington and Fairfax, in Virginia; and the counties of Montgomery and Prince George's in Maryland)"});
        STATE_CITY_MAPPER.put("Connecticut", cities);
        cities = new ArrayList<>();

        /* Florida */
        cities.add(standard);
        cities.add(new String[]{"Boca Raton / Delray Beach / Jupiter", "Palm Beach / Hendry"});
        cities.add(new String[]{"Bradenton", "Manatee"});
        cities.add(new String[]{"Cocoa Beach", "Brevard"});
        cities.add(new String[]{"Daytona Beach", "Volusia"});
        cities.add(new String[]{"Fort Lauderdale", "Broward"});
        cities.add(new String[]{"Fort Myers", "Lee"});
        cities.add(new String[]{"Fort Walton Beach / De Funiak Springs", "Okaloosa / Walton"});
        cities.add(new String[]{"Gainesville", "Alachua"});
        cities.add(new String[]{"Gulf Breeze", "Santa Rosa"});
        cities.add(new String[]{"Key West", "Monroe"});
        cities.add(new String[]{"Miami", "Miami-Dade"});
        cities.add(new String[]{"Naples", "Collier"});
        cities.add(new String[]{"Orlando", "Orange"});
        cities.add(new String[]{"Panama City", "Bay"});
        cities.add(new String[]{"Pensacola", "Escambia"});
        cities.add(new String[]{"Punta Gorda", "Charlotte"});
        cities.add(new String[]{"Sarasota", "Sarasota"});
        cities.add(new String[]{"Sebring", "Highlands"});
        cities.add(new String[]{"St. Augustine", "St. Johns"});
        cities.add(new String[]{"Stuart", "Martin"});
        cities.add(new String[]{"Tallahassee", "Leon"});
        cities.add(new String[]{"Tampa / St. Petersburg", "Pinellas / Hillsborough"});
        cities.add(new String[]{"Vero Beach", "Indian River"});
        STATE_CITY_MAPPER.put("Florida", cities);
        cities = new ArrayList<>();

        /* Georgia */
        cities.add(standard);
        cities.add(new String[]{"Athens", "Clarke"});
        cities.add(new String[]{"Atlanta", "Fulton / Dekalb / Cobb"});
        cities.add(new String[]{"Augusta", "Richmond"});
        cities.add(new String[]{"Jekyll Island / Brunswick", "Glynn"});
        cities.add(new String[]{"Savannah", "Chatham"});
        STATE_CITY_MAPPER.put("Georgia", cities);
        cities = new ArrayList<>();

        /* Guam */
        STATE_CITY_MAPPER.put("Guam", null);

        /* Hawaii */
        STATE_CITY_MAPPER.put("Hawaii", null);

        /* Idaho */
        cities.add(standard);
        cities.add(new String[]{"Bonner's Ferry / Sandpoint", "Bonner / Boundary / Shoshone"});
        cities.add(new String[]{"Coeur d'Alene", "Kootenai"});
        cities.add(new String[]{"Sun Valley / Ketchum", "Blaine / Elmore"});
        STATE_CITY_MAPPER.put("Idaho", cities);
        cities = new ArrayList<>();

        /* Illinois */
        cities.add(standard);
        cities.add(new String[]{"Bolingbrook / Romeoville / Lemont", "Will"});
        cities.add(new String[]{"Chicago", "Cook / Lake"});
        cities.add(new String[]{"O'Fallon / Fairview Heights / Collinsville", "Bond / Calhoun / Clinton / Jersey / Macoupin / Madison / Monroe / St. Clair"});
        cities.add(new String[]{"Oak Brook Terrace", "Dupage"});
        STATE_CITY_MAPPER.put("Illinois", cities);
        cities = new ArrayList<>();

        /* Indiana */
        cities.add(standard);
        cities.add(new String[]{"Bloomington", "Monroe"});
        cities.add(new String[]{"Ft. Wayne", "Allen"});
        cities.add(new String[]{"Hammond / Munster / Merrillville", "Lake"});
        cities.add(new String[]{"Indianapolis / Carmel", "Marion / Hamilton"});
        cities.add(new String[]{"Lafayette / West Lafayette", "Tippecanoe"});
        cities.add(new String[]{"South Bend", "St. Joseph"});
        STATE_CITY_MAPPER.put("Indiana", cities);
        cities = new ArrayList<>();

        /* Iowa */
        cities.add(standard);
        cities.add(new String[]{"Cedar Rapids", "Linn"});
        cities.add(new String[]{"Dallas", "Dallas"});
        cities.add(new String[]{"Des Moines", "Polk"});
        STATE_CITY_MAPPER.put("Iowa", cities);
        cities = new ArrayList<>();

        /* Kansas */
        cities.add(standard);
        cities.add(new String[]{"Kansas City / Overland Park", "Wyandotte / Johnson / Leavenworth"});
        cities.add(new String[]{"Wichita", "Sedgwick"});
        STATE_CITY_MAPPER.put("Kansas", cities);
        cities = new ArrayList<>();

        /* Kentucky */
        cities.add(standard);
        cities.add(new String[]{"Boone", "Boone"});
        cities.add(new String[]{"Kenton", "Kenton"});
        cities.add(new String[]{"Lexington", "Fayette"});
        cities.add(new String[]{"Louisville", "Jefferson"});
        STATE_CITY_MAPPER.put("Kentucky", cities);
        cities = new ArrayList<>();

        /* Louisiana */
        cities.add(standard);
        cities.add(new String[]{"Alexandria / Leesville / Natchitoches", "Allen / Jefferson Davis / Natchitoches / Rapides / Vernon Parishes"});
        cities.add(new String[]{"Baton Rouge", "East Baton Rouge Parish"});
        cities.add(new String[]{"New Orleans", "Orleans / St. Bernard / Jefferson / Plaquemine Parishes"});
        STATE_CITY_MAPPER.put("Louisiana", cities);
        cities = new ArrayList<>();

        /* Maine */
        cities.add(standard);
        cities.add(new String[]{"Bar Harbor", "Hancock"});
        cities.add(new String[]{"Kennebunk / Kittery / Sanford", "York"});
        cities.add(new String[]{"Portland", "Cumberland / Sagadahoc"});
        cities.add(new String[]{"Rockport", "Knox"});
        STATE_CITY_MAPPER.put("Louisiana", cities);
        cities = new ArrayList<>();

        /* Maryland */
        cities.add(standard);
        cities.add(new String[]{"Aberdeen / Bel Air / Belcamp", "Harford"});
        cities.add(new String[]{"Annapolis", "Anne Arundel"});
        cities.add(new String[]{"Baltimore City", "Baltimore City"});
        cities.add(new String[]{"Baltimore County", "Baltimore"});
        cities.add(new String[]{"Cambridge / St. Michaels", "Dorchester / Talbot"});
        cities.add(new String[]{"Centreville", "Queen Anne"});
        cities.add(new String[]{"Columbia", "Howard"});
        cities.add(new String[]{"District of Columbia", "Washington DC (also the cities of Alexandria, Falls Church and Fairfax, and the counties of Arlington and Fairfax, in Virginia; and the counties of Montgomery and Prince George's in Maryland)"});
        cities.add(new String[]{"Frederick", "Frederick"});
        cities.add(new String[]{"Ocean City", "Worcester"});
        STATE_CITY_MAPPER.put("Maryland", cities);
        cities = new ArrayList<>();

        /* Massachusetts */
        cities.add(standard);
        cities.add(new String[]{"Andover", "Essex"});
        cities.add(new String[]{"Boston / Cambridge", "Suffolk, city of Cambridge"});
        cities.add(new String[]{"Burlington / Woburn", "Middlesex less the city of Cambridge"});
        cities.add(new String[]{"Falmouth", "City limits of Falmouth"});
        cities.add(new String[]{"Hyannis", "Barnstable less the city of Falmouth"});
        cities.add(new String[]{"Martha's Vineyard", "Dukes"});
        cities.add(new String[]{"Nantucket", "Nantucket"});
        cities.add(new String[]{"Northampton", "Hampshire"});
        cities.add(new String[]{"Pittsfield", "Berkshire"});
        cities.add(new String[]{"Plymouth / Taunton / New Bedford", "Plymouth / Bristol"});
        cities.add(new String[]{"Quincy", "Norfolk"});
        cities.add(new String[]{"Springfield", "Hampden"});
        cities.add(new String[]{"Worcester", "Worcester"});
        STATE_CITY_MAPPER.put("Maryland", cities);
        cities = new ArrayList<>();

        /* Michigan */
        cities.add(standard);
        cities.add(new String[]{"Ann Arbor", "Washtenaw"});
        cities.add(new String[]{"Benton Harbor / St. Joseph / Stevensville", "Berrien"});
        cities.add(new String[]{"Detroit", "Wayne"});
        cities.add(new String[]{"East Lansing / Lansing", "Ingham / Eaton"});
        cities.add(new String[]{"Grand Rapids", "Kent"});
        cities.add(new String[]{"Holland", "Ottawa"});
        cities.add(new String[]{"Kalamazoo / Battle Creek", "Kalamazoo / Calhoun"});
        cities.add(new String[]{"Mackinac Island", "Mackinac"});
        cities.add(new String[]{"Midland", "Midland"});
        cities.add(new String[]{"Muskegon", "Muskegon"});
        cities.add(new String[]{"Petoskey", "Emmet"});
        cities.add(new String[]{"Pontiac / Auburn Hills", "Oakland"});
        cities.add(new String[]{"South Haven", "Van Buren"});
        cities.add(new String[]{"Traverse City / Leland", "Grand Traverse / Leelanau"});
        STATE_CITY_MAPPER.put("Michigan", cities);
        cities = new ArrayList<>();

        /* Minnesota */
        cities.add(standard);
        cities.add(new String[]{"Duluth", "St. Louis"});
        cities.add(new String[]{"Eagan / Burnsville / Mendota Heights", "Dakota"});
        cities.add(new String[]{"Minneapolis / St. Paul", "Hennepin / Ramsey"});
        cities.add(new String[]{"Rochester", "Olmsted"});
        STATE_CITY_MAPPER.put("Minnesota", cities);
        cities = new ArrayList<>();

        /* Mississippi */
        cities.add(standard);
        cities.add(new String[]{"Oxford", "Lafayette"});
        cities.add(new String[]{"Southaven", "Desoto"});
        cities.add(new String[]{"Starkville", "Oktibbeha"});
        STATE_CITY_MAPPER.put("Mississippi", cities);
        cities = new ArrayList<>();

        /* Missouri */
        cities.add(standard);
        cities.add(new String[]{"Kansas City", "Jackson / Clay / Cass / Platte"});
        cities.add(new String[]{"St. Louis", "St. Louis / St. Louis City / St. Charles / Crawford / Franklin / Jefferson / Lincoln / Warren / Washington"});
        STATE_CITY_MAPPER.put("Missouri", cities);
        cities = new ArrayList<>();

        /* Montana */
        cities.add(standard);
        cities.add(new String[]{"Big Sky / West Yellowstone", "Gallatin"});
        cities.add(new String[]{"Butte", "Silver Bow"});
        cities.add(new String[]{"Glendive / Sidney", "Dawson / Richland"});
        cities.add(new String[]{"Helena", "Lewis and Clark"});
        cities.add(new String[]{"Missoula / Polson / Kalispell", "Missoula / Lake / Flathead"});
        STATE_CITY_MAPPER.put("Montana", cities);
        cities = new ArrayList<>();

        /* Nebraska */
        cities.add(standard);
        cities.add(new String[]{"Omaha", "Douglas"});
        STATE_CITY_MAPPER.put("Nebraska", cities);
        cities = new ArrayList<>();

        /* Nevada */
        cities.add(standard);
        cities.add(new String[]{"Incline Village / Reno / Sparks", "Washoe"});
        cities.add(new String[]{"Las Vegas", "Clark"});
        STATE_CITY_MAPPER.put("Nevada", cities);
        cities = new ArrayList<>();

        /* New Hampshire */
        cities.add(standard);
        cities.add(new String[]{"Concord", "Merrimack"});
        cities.add(new String[]{"Conway", "Caroll"});
        cities.add(new String[]{"Durham", "Strafford"});
        cities.add(new String[]{"Laconia", "Belknap"});
        cities.add(new String[]{"Lebanon / Lincoln / West Lebanon", "Grafton / Sullivan"});
        cities.add(new String[]{"Manchester", "Hillsborough"});
        cities.add(new String[]{"Portsmouth", "Rockingham"});
        STATE_CITY_MAPPER.put("New Hampshire", cities);
        cities = new ArrayList<>();

        /* New Jersey */
        cities.add(standard);
        cities.add(new String[]{"Atlantic City / Ocean City / Cape May", "Atlantic / Cape May"});
        cities.add(new String[]{"Cherry Hill / Moorestown", "Camden / Burlington"});
        cities.add(new String[]{"Eatontown / Freehold", "Monmouth"});
        cities.add(new String[]{"Edison / Piscataway", "Middlesex"});
        cities.add(new String[]{"Flemington", "Hunterdon"});
        cities.add(new String[]{"Newark", "Essex / Bergen / Hudson / Passaic"});
        cities.add(new String[]{"Parsippany", "Morris"});
        cities.add(new String[]{"Princeton / Trenton", "Mercer"});
        cities.add(new String[]{"Somerset", "Somerset"});
        cities.add(new String[]{"Springfield / Cranford / New Providence", "Union"});
        cities.add(new String[]{"Toms River", "Ocean"});
        STATE_CITY_MAPPER.put("New Jersey", cities);
        cities = new ArrayList<>();

        /* New Mexico */
        cities.add(standard);
        cities.add(new String[]{"Carlsbad", "Eddy"});
        cities.add(new String[]{"Las Cruces", "Dona Ana"});
        cities.add(new String[]{"Santa Fe", "Santa Fe"});
        cities.add(new String[]{"Taos", "Taos"});
        STATE_CITY_MAPPER.put("New Mexico", cities);
        cities = new ArrayList<>();

        /* New York */
        cities.add(standard);
        cities.add(new String[]{"Albany", "Albany"});
        cities.add(new String[]{"Binghamton / Owego", "Broome / Tioga"});
        cities.add(new String[]{"Buffalo", "Erie"});
        cities.add(new String[]{"Floral Park / Garden City / Great Neck", "Nassau"});
        cities.add(new String[]{"Glens Falls", "Warren"});
        cities.add(new String[]{"Ithaca / Waterloo / Romulus", "Tompkins / Seneca"});
        cities.add(new String[]{"Kingston", "Ulster"});
        cities.add(new String[]{"Lake Placid", "Essex"});
        cities.add(new String[]{"New York City", "Bronx / Kings / New York / Queens / Richmond"});
        cities.add(new String[]{"Niagara Falls", "Niagara"});
        cities.add(new String[]{"Nyack / Palisades", "Rockland"});
        cities.add(new String[]{"Poughkeepsie", "Dutchess"});
        cities.add(new String[]{"Riverhead / Ronkonkoma / Melville", "Suffolk"});
        cities.add(new String[]{"Rochester", "Monroe"});
        cities.add(new String[]{"Saratoga Springs / Schenectady", "Saratoga / Schenectady"});
        cities.add(new String[]{"Syracuse / Oswego", "Onondaga / Oswego"});
        cities.add(new String[]{"Tarrytown / White Plains / New Rochelle", "Westchester"});
        cities.add(new String[]{"Troy", "Rensselaer"});
        cities.add(new String[]{"Watertown", "Jefferson"});
        cities.add(new String[]{"West Point", "Orange"});
        STATE_CITY_MAPPER.put("New York", cities);
        cities = new ArrayList<>();

        /* North Carolina */
        cities.add(standard);
        cities.add(new String[]{"Asheville", "Buncombe"});
        cities.add(new String[]{"Atlantic Beach / Morehead City", "Carteret"});
        cities.add(new String[]{"Chapel Hill", "Orange"});
        cities.add(new String[]{"Charlotte", "Mecklenburg"});
        cities.add(new String[]{"Durham", "Durham"});
        cities.add(new String[]{"Fayetteville", "Cumberland"});
        cities.add(new String[]{"Greensboro", "Guilford"});
        cities.add(new String[]{"Kill Devil", "Dare"});
        cities.add(new String[]{"Raleigh", "Wake"});
        cities.add(new String[]{"Wilmington", "New Hanover"});
        STATE_CITY_MAPPER.put("North Carolina", cities);
        cities = new ArrayList<>();

        /* North Dakota */
        cities.add(standard);
        cities.add(new String[]{"Dickinson / Beulah", "Stark / Mercer / Billings"});
        cities.add(new String[]{"Williston", "Williams / Mountrail / McKenzie"});
        STATE_CITY_MAPPER.put("North Dakota", cities);
        cities = new ArrayList<>();

        /* Ohio */
        cities.add(standard);
        cities.add(new String[]{"Akron", "Summit"});
        cities.add(new String[]{"Canton", "Stark"});
        cities.add(new String[]{"Cincinnati", "Hamilton / Clermont"});
        cities.add(new String[]{"Cleveland", "Cuyahoga"});
        cities.add(new String[]{"Columbus", "Franklin"});
        cities.add(new String[]{"Dayton / Fairborn", "Greene / Darke / Montgomery"});
        cities.add(new String[]{"Hamilton", "Butler / Warren"});
        cities.add(new String[]{"Medina / Wooster", "Wayne / Medina"});
        cities.add(new String[]{"Mentor", "Lake"});
        cities.add(new String[]{"Sandusky / Bellevue", "Erie / Huron"});
        cities.add(new String[]{"Youngstown", "Mahoning / Trumbull"});
        STATE_CITY_MAPPER.put("Ohio", cities);
        cities = new ArrayList<>();

        /* Oklahoma */
        cities.add(standard);
        cities.add(new String[]{"Enid", "Garfield"});
        cities.add(new String[]{"Oklahoma City", "Oklahoma"});
        STATE_CITY_MAPPER.put("Oklahoma", cities);
        cities = new ArrayList<>();

        /* Oregon */
        cities.add(standard);
        cities.add(new String[]{"Beaverton", "Washington"});
        cities.add(new String[]{"Bend", "Deschutes"});
        cities.add(new String[]{"Clackamas", "Clackamas"});
        cities.add(new String[]{"Eugene / Florence", "Lane"});
        cities.add(new String[]{"Lincoln City", "Lincoln"});
        cities.add(new String[]{"Portland", "Multnomah"});
        cities.add(new String[]{"Seaside", "Clatsop"});
        STATE_CITY_MAPPER.put("Oregon", cities);
        cities = new ArrayList<>();

        /* Pennsylvania */
        cities.add(standard);
        cities.add(new String[]{"Allentown / Easton / Bethlehem", "Lehigh / Northampton"});
        cities.add(new String[]{"Bucks", "Bucks"});
        cities.add(new String[]{"Chester / Radnor / Essington", "Delaware"});
        cities.add(new String[]{"Erie", "Erie"});
        cities.add(new String[]{"Gettysburg", "Adams"});
        cities.add(new String[]{"Harrisburg", "Dauphin County excluding Hershey"});
        cities.add(new String[]{"Hershey", "Hershey"});
        cities.add(new String[]{"Lancaster", "Lancaster"});
        cities.add(new String[]{"Malvern / Frazer / Berwyn", "Chester"});
        cities.add(new String[]{"Mechanicsburg", "Cumberland"});
        cities.add(new String[]{"Montgomery", "Montgomery"});
        cities.add(new String[]{"Philadelphia", "Philadelphia"});
        cities.add(new String[]{"Pittsburgh", "Allegheny"});
        cities.add(new String[]{"Reading", "Berks"});
        cities.add(new String[]{"Scranton", "Lackawanna"});
        cities.add(new String[]{"State College", "Centre"});
        STATE_CITY_MAPPER.put("Pennsylvania", cities);
        cities = new ArrayList<>();

        /* Puerto Rico */
        STATE_CITY_MAPPER.put("Puerto Rico", null);

        /* Rhode Island */
        cities.add(standard);
        cities.add(new String[]{"East Greenwich / Warwick / North Kingstown", "Kent / Washington"});
        cities.add(new String[]{"Jamestown / Middletown / Newport", "Newport"});
        cities.add(new String[]{"Providence / Bristol", "Providence / Bristol"});
        STATE_CITY_MAPPER.put("Rhode Island", cities);
        cities = new ArrayList<>();

        /* South Carolina */
        cities.add(standard);
        cities.add(new String[]{"Aiken", "Aiken"});
        cities.add(new String[]{"Charleston", "Charleston / Berkeley / Dorchester\t"});
        cities.add(new String[]{"Columbia", "Richland / Lexington"});
        cities.add(new String[]{"Hilton Head", "Beaufort"});
        cities.add(new String[]{"Myrtle Beach", "Horry"});
        STATE_CITY_MAPPER.put("South Carolina", cities);
        cities = new ArrayList<>();

        /* South Dakota */
        cities.add(new String[]{"Hot Springs", "Fall River / Custer"});
        cities.add(new String[]{"Rapid City", "Pennington"});
        cities.add(new String[]{"Sturgis / Spearfish", "Meade / Butte / Lawrence"});
        STATE_CITY_MAPPER.put("South Dakota", cities);
        cities = new ArrayList<>();

        /* Tennessee */
        cities.add(standard);
        cities.add(new String[]{"Brentwood / Franklin", "Williamson"});
        cities.add(new String[]{"Chattanooga", "Hamilton"});
        cities.add(new String[]{"Knoxville", "Knox"});
        cities.add(new String[]{"Memphis", "Shelby"});
        cities.add(new String[]{"Nashville", "Davidson"});
        STATE_CITY_MAPPER.put("Tennessee", cities);
        cities = new ArrayList<>();

        /* Texas */
        cities.add(standard);
        cities.add(new String[]{"Austin", "Travis"});
        cities.add(new String[]{"Big Spring", "Howard"});
        cities.add(new String[]{"College Station", "Brazos"});
        cities.add(new String[]{"Corpus Christi", "Nueces"});
        cities.add(new String[]{"Dallas", "Dallas"});
        cities.add(new String[]{"El Paso", "El Paso"});
        cities.add(new String[]{"Galveston", "Galveston"});
        cities.add(new String[]{"Houston (L.B. Johnson Space Center)", "Montgomery / Fort Bend / Harris"});
        cities.add(new String[]{"Laredo", "Webb"});
        cities.add(new String[]{"McAllen", "Hidalgo"});
        cities.add(new String[]{"Midland", "Midland"});
        cities.add(new String[]{"Pearsall", "Frio / Medina / La Salle"});
        cities.add(new String[]{"Pecos", "Reeves"});
        cities.add(new String[]{"Plano", "Collin"});
        cities.add(new String[]{"Round Rock", "Williamson"});
        cities.add(new String[]{"San Angelo", "Tom Green"});
        cities.add(new String[]{"San Antonio", "Bexar"});
        cities.add(new String[]{"South Padre Island", "Cameron"});
        cities.add(new String[]{"Waco", "McLennan"});
        STATE_CITY_MAPPER.put("Texas", cities);
        cities = new ArrayList<>();

        /* Utah */
        cities.add(standard);
        cities.add(new String[]{"Moab", "Grand"});
        cities.add(new String[]{"Park City", "Summit"});
        cities.add(new String[]{"Provo", "Utah"});
        cities.add(new String[]{"Salt Lake City", "Salt Lake / Tooele"});
        STATE_CITY_MAPPER.put("Utah", cities);
        cities = new ArrayList<>();

        /* Vermont */
        cities.add(standard);
        cities.add(new String[]{"Burlington / St. Albans / Middlebury", "Chittenden / Franklin / Addison"});
        cities.add(new String[]{"Manchester", "Bennington"});
        cities.add(new String[]{"Montpelier", "Washington"});
        cities.add(new String[]{"Stowe", "Lamoille"});
        cities.add(new String[]{"White River Junction", "Windsor"});
        STATE_CITY_MAPPER.put("Vermont", cities);
        cities = new ArrayList<>();

        /* Virginia Islands */
        cities.add(standard);
        STATE_CITY_MAPPER.put("Virginia Islands", null);

        /* Virginia */
        cities.add(standard);
        cities.add(new String[]{"Abingdon", "Washington"});
        cities.add(new String[]{"Blacksburg", "Montgomery"});
        cities.add(new String[]{"Charlottesville", "City of Charlottesville / Albemarle / Greene"});
        cities.add(new String[]{"District of Columbia", "Washington DC (also the cities of Alexandria, Falls Church and Fairfax, and the counties of Arlington and Fairfax, in Virginia; and the counties of Montgomery and Prince George's in Maryland)"});
        cities.add(new String[]{"Loudoun", "Loudoun"});
        cities.add(new String[]{"Lynchburg", "Campbell / Lynchburg City"});
        cities.add(new String[]{"Richmond", "City of Richmond"});
        cities.add(new String[]{"Roanoke", "City limits of Roanoke"});
        cities.add(new String[]{"Virginia Beach", "City of Virginia Beach"});
        cities.add(new String[]{"Wallops Island", "Accomack"});
        cities.add(new String[]{"Warrenton", "Fauquier"});
        cities.add(new String[]{"Williamsburg / York", "James City / York Counties / City of Williamsburg"});
        STATE_CITY_MAPPER.put("Virginia", cities);
        cities = new ArrayList<>();

        /* Washington */
        cities.add(standard);
        cities.add(new String[]{"Everett / Lynnwood", "Snohomish"});
        cities.add(new String[]{"Ocean Shores", "Grays Harbor"});
        cities.add(new String[]{"Olympia / Tumwater", "Thurston"});
        cities.add(new String[]{"Port Angeles / Port Townsend", "Clallam / Jefferson"});
        cities.add(new String[]{"Richland / Pasco", "Benton / Franklin"});
        cities.add(new String[]{"Seattle", "King"});
        cities.add(new String[]{"Spokane", "Spokane"});
        cities.add(new String[]{"Tacoma", "Pierce"});
        cities.add(new String[]{"Vancouver", "Clark / Cowlitz / Skamania"});
        STATE_CITY_MAPPER.put("Washington", cities);
        cities = new ArrayList<>();

        /* West Virginia */
        cities.add(standard);
        cities.add(new String[]{"Charleston", "Kanawha"});
        cities.add(new String[]{"Morgantown", "Monongalia"});
        cities.add(new String[]{"Wheeling", "Ohio"});
        STATE_CITY_MAPPER.put("West Virginia", cities);
        cities = new ArrayList<>();

        /* Wisconsin */
        cities.add(standard);
        cities.add(new String[]{"Appleton", "Outagamie"});
        cities.add(new String[]{"Brookfield / Racine", "Waukesha / Racine"});
        cities.add(new String[]{"Madison", "Dane"});
        cities.add(new String[]{"Milwaukee", "Milwaukee"});
        cities.add(new String[]{"Sheboygan", "Sheboygan"});
        cities.add(new String[]{"Sturgeon Bay", "Door"});
        cities.add(new String[]{"Wisconsin Dells", "Columbia"});
        STATE_CITY_MAPPER.put("Wisconsin", cities);
        cities = new ArrayList<>();

        /* Wyoming */
        cities.add(standard);
        cities.add(new String[]{"Cody", "Park"});
        cities.add(new String[]{"Evanston / Rock Springs", "Sweetwater / Uinta"});
        cities.add(new String[]{"Gillette", "Campbell"});
        cities.add(new String[]{"Jackson / Pinedale", "Teton / Sublette"});
        STATE_CITY_MAPPER.put("Wyoming", cities);
    }
}
