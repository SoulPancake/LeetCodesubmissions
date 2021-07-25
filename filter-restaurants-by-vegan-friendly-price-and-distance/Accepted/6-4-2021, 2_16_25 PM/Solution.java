// https://leetcode.com/problems/filter-restaurants-by-vegan-friendly-price-and-distance

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        return Arrays.stream(restaurants)
                .filter(v-> veganFriendly == 1 ? (v[2] == 1) : (v[2]  == 1 || v[2]  == 0))
                .filter(v-> v[3]<=maxPrice)
                .filter(v -> v[4] <= maxDistance)
                .sorted((v1, v2) -> v2[1] == v1[1] ? v2[0] - v1[0] : v2[1] - v1[1])
                .map(v-> new Integer(v[0]))
                .collect(Collectors.toList());
    }
}