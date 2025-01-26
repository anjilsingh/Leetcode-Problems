class DetectSquares {
     //create a map and an arrayList

    Map<List<Integer>,Integer>ptsCount;
    List<List<Integer>>pts;
    public DetectSquares() {
        ptsCount=new HashMap<>();
        pts=new ArrayList<>();
    }
    
    public void add(int[] point) {
        List<Integer>p=Arrays.asList(point[0],point[1]);
        ptsCount.put(p,ptsCount.getOrDefault(p,0)+1);
        pts.add(p);
    }
    
    public int count(int[] point) {
        //is ppoint ke liye apan kitne rrectangle bana skte hai

        int px=point[0];
        int py=point[1];
        int res=0;

        for(List<Integer>pt:pts){
            int x=pt.get(0);
            int y=pt.get(1);

            //when the point cant be diagonal
            //if its x or y is same or the diff of x and y are not same

            if(Math.abs(px-x)!=Math.abs(py-y)||x==px||y==py){
                continue;
            }

         res += ptsCount.getOrDefault(Arrays.asList(x, py), 0) * 
                   ptsCount.getOrDefault(Arrays.asList(px, y), 0);
        }
        return res;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */