/**
 * @Description
 * @Auther: bichengfei
 * @Data: 2019/4/8 15:04
 **/
public class _08 {

    public int JumpFloor(int target) {
        int preNum = 2;
        int prePreNum = 1;
        int total = 0;
        if(target == 0)
            return 0;
        if(target == 1)
            return 1;
        if(target == 2)
            return 2;
        for(int i = 3;i <= target;i ++){
            total = preNum + prePreNum;
            prePreNum = preNum;
            preNum = total;
        }
        return total;
    }
}
