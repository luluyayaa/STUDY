import javax.sql.XAConnection;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 ATM系统的入口类
 */
public class ATMSystem {
    public static void main(String[] args) {
        //1定义账户类
        //2定义集合存储账户
        ArrayList<Account> accounts = new ArrayList<>();
        //3展示系统首页
        while (true) {
            System.out.println("==================luluATM==================");
            System.out.println("1.log in");
            System.out.println("2.open an account");
            Scanner sc = new Scanner(System.in);
            System.out.println("Please select operation:");
            String command = sc.next();
            switch (command){
                case "1" :
                    //用户登录操作
                    login(accounts,sc);
                    break;
                    case "2" :
                        //用户账户开户
                        register(accounts,sc);
                        break;
                        default :
                            System.out.println("Unknown Operation");
            }
        }
    }

    /**
     * 登录功能
     * @param accounts
     * @param sc
     */
    private static void login(ArrayList<Account> accounts, Scanner sc) {
        System.out.println("==================Welcome==================");
        //判断账户集合中是否存在账户，不存在则不能进行
        if(accounts.size() == 0){
            System.out.println("Please open an account first");
            return;
        }
        while (true) {
            System.out.println("Enter your cardid");
            String cardId = sc.next();
            Account acc = getAccountByCardId(cardId,accounts);
            if (acc != null) {
                //卡号存在认证密码
                while (true) {
                    System.out.println("Enter your password");
                    String password = sc.next();
                    //判断密码合法性
                    if(acc.getPassWord().equals(password)){
                        //登录成功
                        System.out.println("Welcome! "+acc.getUserName());
                        //登录后的操作也
                        showUserCommand(sc,acc,accounts);
                        return;//干掉登录方法
                        
                    }else{
                        System.out.println("Wrong password");
                    }
                }
            }else {
                System.out.println("Sorry,please try again");
            }
        }
    }

    /**
     * 展示登录操作页
     */
    private static void showUserCommand(Scanner sc,Account acc,ArrayList<Account> accounts) {
        while (true) {
            System.out.println("==================Operation==================");
            System.out.println("1.query");
            System.out.println("2.deposit");
            System.out.println("3.withdraw");
            System.out.println("4.transfer");
            System.out.println("5.change password");
            System.out.println("6.log out");
            System.out.println("7.cancel account");
            System.out.println("please select:");
            int command = sc.nextInt();
            switch (command) {
                case 1:
                    //查询账户
                    showAccount(acc);
                    break;
                    case 2 :
                        //存款
                        depositMoney(acc,sc);
                        break;
                        case 3 :
                            //取款
                            drawMoney(acc, sc);
                            break;
                            case 4 :
                                //转账
                                transferMoney(acc,sc,accounts);
                                break;
                                case 5 :
                                    //修改密码
                                    updatePassWord(acc, sc);
                                    return;
                                    case 6 :
                                        //退出
                                        return;//停止当前方法
                                        case 7 :
                                            //注销账户
                                            //从集合中删除当前对象
                                            if(deleteAccount(acc,accounts,sc)){
                                                return;
                                            }else {
                                                //没有销户成功
                                                break;
                                            }
                default:
                    System.out.println("Unknown operation");
            }
        }

    }

    /**
     * 从集合中删除账户
     * @param acc
     * @param accounts
     * @param sc
     */

    private static boolean deleteAccount(Account acc, ArrayList<Account> accounts,Scanner sc) {
        System.out.println("Do you want to cancel your accont?(Y/N)");
        String rs = sc.next();
        switch (rs){
            case "Y":
                if(acc.getMoney()>0){
                    System.out.println("Your have money remained in your account, please draw it first");
                } else {
                    accounts.remove(acc);
                    System.out.println("Operation successful");
                    return true;
                }
            default:
        }
        return false;
    }

    /**
     * 修改密码
     * @param acc 当前账户
     * @param sc 扫描器
     */
    private static void updatePassWord(Account acc, Scanner sc) {
        System.out.println("==================Updata Password==================");
        while (true) {
            System.out.println("Enter your current password");
            String passWord = sc.next();
            if(passWord.equals(acc.getPassWord())){
                while (true) {
                    System.out.println("Enter your new password");
                    String  newPassWord = sc.next();
                    System.out.println("Confirm your new password");
                    String  okPassWord = sc.next();
                    if (newPassWord.equals(okPassWord)) {
                        //2次密码一致可以修改
                        acc.setPassWord(newPassWord);
                        System.out.println("Operation successful");
                        return;
                    }else{
                        //2次密码不一致
                        System.out.println("Sorry,there are two different entries.Please try again");
                    }
                }
            }else{
                System.out.println("Wrong Password.");
            }
        }

    }

    /**
     * 转账功能
     * @param acc 自己的账户
     * @param sc  扫描器
     * @param accounts 账户集合
     */

    private static void transferMoney(Account acc, Scanner sc, ArrayList<Account> accounts) {
        System.out.println("==================TransferMoney==================");
        //判断是否足够两个账号
        if(accounts.size() <2){
            System.out.println("Unsupported Operation");
            return;
        }
        //开始转账
        if(acc.getQuotaMoney() == 0) {
            System.out.println("You dont have a cent");
            return;
        }
        while (true) {
            System.out.println("Enter the cardId of the opposite party");
            String cardId  = sc.next();
            //不能是自己的卡号
            if (cardId.equals(acc.getCardId())) {
                System.out.println("Please dont use your own cardId!");
                continue;
            }
            //查询卡号是否存在
            Account account = getAccountByCardId(cardId,accounts);
            if(account == null){
                System.out.println("Unknown cardId");
            }else {
                String userName = account.getUserName();
                System.out.println("Enter the username of the opposite party ");
                String tip = "*" + userName.substring(1);
                System.out.println("Enter [" + tip + "] 's prename:");
                String preName = sc.next();
                if(userName.startsWith(preName)){
                        //认证通过，真正开始转账了
                    while (true) {
                        System.out.println("Enter the money you want to transfer");
                        double moeny = sc.nextDouble();
                        if(moeny > acc.getMoney()){
                            //余额不足
                            System.out.println("Sorry,you dont have enough money,you can transfer at most" + acc.getMoney());
                        }else {
                            //余额足够
                            acc.setMoney(acc.getMoney()-moeny);
                            account.setMoney(account.getMoney() + moeny);
                            System.out.println("Operation successful,your account have " + acc.getMoney() + " remained");
                            return;//干掉转账方法
                        }
                    }

                }else{
                    System.out.println("Wrong cardId");
                }

            }
        }



    }

    /**
     * 取钱功能
     * @param acc 当前账户
     * @param sc 扫描器
     */
    private static void drawMoney(Account acc, Scanner sc) {
            System.out.println("==================DrawMoneyt==================");
            //判断余额是否够100元
            if(acc.getMoney()<100) {
                System.out.println("Sorry,you are too poor");
                return;//拦截
            }

        while (true) {
            System.out.println("Enter withdrawal amount");
            double money = sc.nextDouble();
            if(money > acc.getMoney()|| money>acc.getQuotaMoney()){
                System.out.println("Unsupported operation");
                return;
            }else {
                System.out.println("Draw" + money + "successfully");
                acc.setMoney(acc.getMoney()-money);
                showAccount(acc);
                return;
    }
        }

    }

    /**
     * 存钱
     * @param acc 当前用户对象
     * @param sc 扫描器
     */
    private static void depositMoney(Account acc, Scanner sc) {
        System.out.println("==================Deposit==================");
        System.out.println("Please input your deposit amount");
        double money = sc.nextDouble();
        //更新账户余额
        acc.setMoney(acc.getMoney()+money);
        System.out.println("Operation successful!");
    }

    /**
     * 展示账户信息
     * @param acc
     */
    private static void showAccount(Account acc) {
        System.out.println("==================This is your information==================");
        System.out.println("CardId: " + acc.getCardId());
        System.out.println("Username:" + acc.getUserName());
        System.out.println("Money:" + acc.getMoney());
        System.out.println("Quotamoney:" + acc.getQuotaMoney());
    }

    /**
     * 用户开户功能实现
     * @param accounts 接收账户集合
     */
    private static void register(ArrayList<Account> accounts,Scanner sc) {
        System.out.println("==================Account==================");
        //创建账户对象，用于封装账户信息
        Account account = new Account();
        //录入信息
        System.out.println("Enter username:");
        String userName = sc.next();
        account.setUserName(userName);
        while (true) {
            System.out.println("Enter password:");
            String passWord = sc.next();
            System.out.println("Confirm password:");
            String okPassWord = sc.next();
            if (okPassWord.equals(passWord)) {
                account.setPassWord(passWord);
                break;  //密码通过退出死循环
            } else {
                System.out.println("Sorry,please try again");
            }
        }
        System.out.println("Enter current limit:");
        double quotaMoney = sc.nextDouble();
        account.setQuotaMoney(quotaMoney);

        //为账户随机一个8位且与其他账户不同的卡号
        String cardId = getRandomCardId(accounts);
        account.setCardId(cardId);
        //账户对象添加到集合
        accounts.add(account);
        System.out.println("Welcome! "+userName);
        System.out.println("Your cardid is:" +cardId+" Please keep it safe");

    }

    /**
     * 为账户随机一个8位且与其他账户不同的卡号
     * @return
     */

    private static String getRandomCardId(ArrayList<Account> accounts) {
        Random r = new Random();
        while (true) {
            String cardId = "";
            for (int i = 0; i < 8; i++) {
                cardId += r.nextInt(10);
            }
            //判断8位卡号是否重复
            Account acc = getAccountByCardId(cardId, accounts);
            if (acc == null) {
                return cardId;
            }
        }
    }

    /**
     * 根据账号查询出账户对象
     * @param cardId  卡号
     * @param accounts 全部账户的集合
     * @return 返回账户对象
     */
    private static Account getAccountByCardId(String cardId,ArrayList<Account> accounts) {
        for (int i = 0; i < accounts.size() ; i++) {
            Account acc = accounts.get(i);
            if (acc.getCardId().equals(cardId)) {
                return  acc;
            }
        }
        return null;
    }
}


