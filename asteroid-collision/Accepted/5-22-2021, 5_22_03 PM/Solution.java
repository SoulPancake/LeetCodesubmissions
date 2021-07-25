// https://leetcode.com/problems/asteroid-collision


//Lyft amazon interview question

//Use a stack
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack=new Stack<>();
        
        for(int i=0;i<asteroids.length;i++)
        {
            if(stack.isEmpty() || asteroids[i]>0) //Asteroids[i] is positive
                stack.push(asteroids[i]);
            else
            {
                while(true)
                {
                    int peek=stack.peek();
                    if(peek<0)
                    {
                        stack.push(asteroids[i]);
                        break;
                    }else if(peek==-asteroids[i])
                    {
                        stack.pop();  //Both explode
                        break;     //Not adding the asteroid
                        
                    }else if(peek>-asteroids[i])                        
                    {
                        break; //Destroying the incoming asteroid
                    }else
                    {
                        stack.pop();
                        if(stack.isEmpty()) //Blew everything up already
                        {
                            stack.push(asteroids[i]);
                            break;
                        }
                        
                    }
                }
            }
            
        }
        
        int[] output_array=new int[stack.size()];
        for(int i=stack.size()-1;i>=0;i--)
        {
            output_array[i]=stack.pop();
        }
        return output_array;
    }
}