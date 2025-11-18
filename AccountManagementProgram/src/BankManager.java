import java.util.HashMap;

public class BankManager {
    private HashMap<String, Integer> account;

    // 생성자
    public BankManager() {
        account = new HashMap<>();
    }

    /**
     * 입금처리 함수
     * @param name 이름
     * @param amount 잔액
     */
    public void deposit(String name, int amount) {
        // 계좌가 없으면 생성 후 초기화 
        if (!account.containsKey(name)) 
            account.put(name, 0);
        // 계좌 잔액 업데이트
        account.put(name, account.get(name) + amount);
    }

    /**
     * 출금처리 함수
     * @param name 이름
     * @param amount 잔액
     * @return 남은 잔액
     */
    public int withdraw(String name, int amount) {
        // 계좌가 없을 시
        if (!account.containsKey(name)) return -1;

        int balance = account.get(name);
        if (balance < amount) return -1;
        
        balance -= amount;
        account.put(name, balance);
        return balance;
    }

    /**
     * 계좌명에 해당하는 잔고를 가져오는 함수
     * @param name
     * @return 잔고
     */
    public int getBalance(String name) {
        return account.get(name);
    }

    /**
     * 계좌명에 해당하는 잔고를 "(계좌명:잔고액)" 형식의 문자열로 가져오는 함수
     * @param name
     * @return (계좌명:잔고액)
     */
    public String getBalanceString(String name) {
        if (!account.containsKey(name)) {
            return "(" + name + ":계좌없음)";
        }

        return "(" + name + ":" + getBalance(name) + "원)";
    }

    /**
     * 모든 계좌의 잔고 정보를 문자열로 가져오는 함수
     * @return 모든 (계좌명:잔고액)
     */
    public String[] getAllBalanceString() {
        String allAccountBalance[] = new String[account.size()];
        int i = 0;
        for (var entry : account.entrySet()) {
            allAccountBalance[i++] = getBalanceString(entry.getKey());
        }

        return allAccountBalance;
    }

}
