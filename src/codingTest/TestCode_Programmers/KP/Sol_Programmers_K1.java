package codingTest.TestCode_Programmers.KP;

// KP1
public class Sol_Programmers_K1 {

    public int solution(int money, int minratio, int maxratio, int ranksize, int threshold, int months) {
        long ownMoney = money;
        long ownGuessMoney = ownMoney - ownMoney % 100;
        int[] arrTaxRatio = new int[101];

        // 재산 범위 셋팅
        // 최소값 + 1 ~ 최댓값
        if (threshold == 0) {
            for (int i = 0; i < minratio; ++i) {
                arrTaxRatio[i] = threshold + (ranksize - 1);
            }
        } else {
            for (int i = 0; i < minratio; ++i) {
                arrTaxRatio[i] = threshold - 1;
            }
        }
        int j = 1;
        for (int i = minratio; i <= maxratio; ++i, ++j) {
            arrTaxRatio[i] = (threshold + (j * ranksize - 1));
        }
        j = (j == 1) ? 1 : --j;
        for (int i = maxratio + 1; i <= 100; ++i) {
            arrTaxRatio[i] = (threshold + (j * ranksize - 1));
        }

        // 재산 범위 찾기
        int month = 1;
        long totalMoney = ownMoney;
        while (month <= months) {
            int taxRatio = 0;
            if (ownGuessMoney > arrTaxRatio[maxratio]) {
                taxRatio = maxratio;
            } else if (ownGuessMoney <= arrTaxRatio[minratio] && ownGuessMoney < threshold) {
                taxRatio = 0;
            } else if (ownGuessMoney <= arrTaxRatio[minratio]) {
                taxRatio = minratio;
            } else {
                for (int i = 0; i < 100; ++i) {
                    if (ownGuessMoney > arrTaxRatio[i] && ownGuessMoney <= arrTaxRatio[i + 1]) {
                        taxRatio = i + 1; // 세율
                        break;
                    }
                }
            }
            if (taxRatio == 0)
                break;
            long accessTax = ownGuessMoney * taxRatio / 100;
            totalMoney = ownMoney - accessTax;
            ownMoney = totalMoney;
            ownGuessMoney = ownMoney - ownMoney % 100;

            ++month;
        }

        return (int) totalMoney;
    }

    public static void main(String[] args) {
        Sol_Programmers_K1 sol = new Sol_Programmers_K1();
        System.out.println(sol.solution(12345678, 10, 20, 250000, 10000000, 4));
        System.out.println(sol.solution(1000000000, 50, 99, 100000, 0, 6));
        System.out.println(sol.solution(123456789, 0, 0, 1, 0, 360));
    }
}
