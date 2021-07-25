// https://leetcode.com/problems/the-dining-philosophers

class DiningPhilosophers {
private:
    // one mutex per fork
    std::array<std::mutex, 5> mutexes;
public:
    DiningPhilosophers() {
        
    }

    void wantsToEat(int philosopher,
                    function<void()> pickLeftFork,
                    function<void()> pickRightFork,
                    function<void()> eat,
                    function<void()> putLeftFork,
                    function<void()> putRightFork) {
        
        // find the left and right fork numbers
        int left = philosopher;
        int right = (philosopher + 1) % 5;
        
        // ordered lock to avoid deadlock: fork with min number goes first
        std::lock_guard<std::mutex> first(mutexes[std::min(left, right)]);
        std::lock_guard<std::mutex> second(mutexes[std::max(left, right)]);
        
        // do the work - fork order does not actualy matter here
        pickLeftFork(); pickRightFork(); eat(); putRightFork(); putLeftFork();
    }
};