select x,y,z,
    case 
        when x+y > z and y+z > x and x+z > y Then 'Yes'
        Else "No"
    End as triangle
from Triangle
