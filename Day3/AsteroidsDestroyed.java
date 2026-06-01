/*
    You are given an integer mass, which represents the original mass of a planet. 
    You are further given an integer array asteroids, where asteroids[i] is the mass of the ith asteroid.
    You can arrange for the planet to collide with the asteroids in any arbitrary order. If the mass of the planet is greater 
    than or equal to the mass of the asteroid, 
    the asteroid is destroyed and the planet gains the mass of the asteroid. Otherwise, the planet is destroyed.
    Return true if all asteroids can be destroyed. Otherwise, return false.
*/

/*
// Approach (Greedy):

Sort the asteroids in ascending order.
Traverse the sorted array.
If the current mass is greater than or equal to the asteroid's mass, absorb it and increase the mass.
Otherwise, return false since the asteroid cannot be destroyed.
If all asteroids are absorbed successfully, return true.

Intuition:
Absorbing smaller asteroids first increases the planet's mass as much as possible, making it easier to absorb larger asteroids later.

Complexity:

Time: O(n log n) (due to sorting)
Space: O(1) (excluding sorting space)

## Note: Use long for mass to avoid integer overflow when the mass becomes very large.
*/

class AsteroidsDestroyed{
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long currmass = mass;
        for(int i =0; i<asteroids.length; i++){
            if(currmass < asteroids[i]){
                return false;
            }
            else
                currmass += asteroids[i];
        }
        return true;
    }
}