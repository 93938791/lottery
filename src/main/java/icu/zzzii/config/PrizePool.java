package icu.zzzii.config;
import java.util.List;

public class PrizePool {
    private List<Pool> PrizePool;

    public static class Pool {
        private int pay;  // 奖池价格
        private double probability;  // 奖品概率
        private List<Integer> prizes;  // 奖品列表
        private List<Integer> consolationPrize;  // 安慰奖

        public int getPay() {
            return pay;
        }

        public void setPay(int pay) {
            this.pay = pay;
        }

        public double getProbability() {
            return probability;
        }

        public void setProbability(double probability) {
            this.probability = probability;
        }

        public List<Integer> getPrizes() {
            return prizes;
        }

        public void setPrizes(List<Integer> prizes) {
            this.prizes = prizes;
        }

        public List<Integer> getConsolationPrize() {
            return consolationPrize;
        }

        public void setConsolationPrize(List<Integer> consolationPrize) {
            this.consolationPrize = consolationPrize;
        }

        @Override
        public String toString() {
            return "Pool{" +
                    "pay=" + pay +
                    ", probability=" + probability +
                    ", prizes=" + prizes +
                    ", consolationPrize=" + consolationPrize +
                    '}';
        }
    }


    public List<Pool> getPrizePool() {
        return PrizePool;
    }

    public void setPrizePool(List<Pool> prizePool) {
        PrizePool = prizePool;
    }

    @Override
    public String toString() {
        return "PrizePool{" +
                "PrizePool=" + PrizePool +
                '}';
    }
}
