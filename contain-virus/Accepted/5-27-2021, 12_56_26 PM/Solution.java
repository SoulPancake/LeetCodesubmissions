// https://leetcode.com/problems/contain-virus

class Solution {

  private static enum Status {
    UNINFECTED(0), CONTAMINATED(1), QUARANTINED(2);

    private int id;

    Status(int id) {
      this.id = id;
    }

    int getId() {
      return this.id;
    }
  }

  private static final class Point {
    int region;

    int x, y;

    Point(int x, int y, int region) {
      this.x = x;
      this.y = y;
      this.region = region;
    }
  }

  private static class Counter {
    int value;

    Counter(int value) {
      this.value = value;
    }

    int incrementAndGet() {
      value++;
      return value;
    }

    int get() {
      return value;
    }
  }

  public int containVirus(int[][] grid) {
    return containVirus(grid, new Counter(0), 0);
  }

  private Point unvisitedVirusPoint(int[][] grid, boolean[][] visited, Counter counter) {
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (isContaminated(grid, i, j) && !visited[i][j]) {
          return new Point(i, j, counter.incrementAndGet());
        }
      }
    }
    return null;
  }

  private int containVirus(int[][] grid, Counter counter, int walls) {
    boolean[][] visited = new boolean[grid.length][grid[0].length];

    /* DFS to figure out the regions. Regions are captured in the points[][] array. Each region in the points[][] will have a unique region id */
    Point start = unvisitedVirusPoint(grid, visited, counter);
    if (start == null) {
      return walls;
    }
    Point[][] points = new Point[grid.length][grid[0].length];
    Stack<Point> q = new Stack<>();
    q.add(start);
    while (!q.isEmpty()) {
      Point top = q.pop();
      int x = top.x;
      int y = top.y;
      visited[x][y] = true;
      points[x][y] = top;

      if (x > 0) {
        if (!visited[x - 1][y]) {
          if (isContaminated(grid, x - 1, y)) {
            q.push(new Point(x - 1, y, top.region));
          }
        }
      }

      if (x < grid.length - 1) {
        if (!visited[x + 1][y]) {
          if (isContaminated(grid, x + 1, y)) {
            q.push(new Point(x + 1, y, top.region));
          }
        }
      }

      if (y > 0) {
        if (!visited[x][y - 1]) {
          if (isContaminated(grid, x, y - 1)) {
            q.push(new Point(x, y - 1, top.region));
          }
        }
      }

      if (y < grid[x].length - 1) {
        if (!visited[x][y + 1]) {
          if (isContaminated(grid, x, y + 1)) {
            q.push(new Point(x, y + 1, top.region));
          }
        }
      }

      if (q.isEmpty()) {
        Point next = unvisitedVirusPoint(grid, visited, counter);
        if (next != null) {
          q.push(next);
        }
      }
    }

    /* After regions are marked, figure out the damage each region can cause. Damage needs to be unique per region (and they can be close to each other so we need to have a separate visited data structure per region */
    int len = counter.get() + 1;
    int[] wallsByRegion = new int[len];
    int[] contaminationsByRegion = new int[len];
    boolean[][][] infectionVisit = new boolean[len][grid.length][grid[0].length];

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] == 0) {
          if (i < grid.length - 1) {
            if (isContaminated(grid, i + 1, j)) {
              updateBookkeeping(infectionVisit, wallsByRegion, contaminationsByRegion, points[i + 1][j].region, i, j);
            }
          }
          if (i > 0) {
            if (isContaminated(grid, i - 1, j)) {
              updateBookkeeping(infectionVisit, wallsByRegion, contaminationsByRegion, points[i - 1][j].region, i, j);
            }
          }
          if (j < grid[i].length - 1) {
            if (isContaminated(grid, i, j + 1)) {
              updateBookkeeping(infectionVisit, wallsByRegion, contaminationsByRegion, points[i][j + 1].region, i, j);
            }
          }
          if (j > 0) {
            if (isContaminated(grid, i, j - 1)) {
              updateBookkeeping(infectionVisit, wallsByRegion, contaminationsByRegion, points[i][j - 1].region, i, j);
            }
          }
        }
      }
    }

    /* Pick the region which causes the max damage */
    int maxInfectionRegion = -1;
    int maxInfection = Integer.MIN_VALUE;
    for (int i = 1; i < contaminationsByRegion.length; i++) {
      if (maxInfection < contaminationsByRegion[i]) {
        maxInfection = contaminationsByRegion[i];
        maxInfectionRegion = i;
      }
    }

    /* Lookup walls needed from the bookkeeping and quarantine that region else contaminate for next iteration */
    for (int i = 0; i < points.length; i++) {
      for (int j = 0; j < points[i].length; j++) {
        Point n = points[i][j];
        if (n != null) {
          if (n.region == maxInfectionRegion) {
            grid[n.x][n.y] = Status.QUARANTINED.getId();
          } else {
            int x = n.x;
            int y = n.y;
            if (x < grid.length - 1) {
              contaminate(grid, x + 1, y);
            }
            if (x > 0) {
              contaminate(grid, x - 1, y);
            }
            if (y < grid[x].length - 1) {
              contaminate(grid, x, y + 1);
            }
            if (y > 0) {
              contaminate(grid, x, y - 1);
            }
          }
        }
      }
    }

    int currWalls = wallsByRegion[maxInfectionRegion];
    return (currWalls == 0) ? walls : containVirus(grid, counter, walls + currWalls);
  }

  private void contaminate(int[][] grid, int x, int y) {
    if (grid[x][y] == Status.UNINFECTED.getId()) {
      grid[x][y] = Status.CONTAMINATED.getId();
    }
  }

  private boolean isContaminated(int[][] grid, int x, int y) {
    return grid[x][y] == Status.CONTAMINATED.getId();
  }

  private void updateBookkeeping(boolean[][][] infectionVisit, int[] wallsByRegion, int[] contaminationsByRegion,
      int region, int i, int j) {
    wallsByRegion[region]++;
    if (!infectionVisit[region][i][j]) {
      contaminationsByRegion[region]++;
      infectionVisit[region][i][j] = true;
    }
  }
}