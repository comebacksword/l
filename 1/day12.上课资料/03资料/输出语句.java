1.��¼ע��������ı�д
System.out.println("======��ӭ�����뵽����ATMϵͳ===============");
System.out.println("1����¼�˻�");
System.out.println("2��ע���˻�");
System.out.println("����ѡ�������");
2.
System.out.println("==================��ӭ�����뵽��¼����======================");
3.��¼��չʾ�Ľ���
System.out.println("==================��ӭ�����뵽��������======================");
System.out.println("1����ѯ");
System.out.println("2�����");
System.out.println("3��ȡ��");
System.out.println("4��ת��");
System.out.println("5���޸�����");
System.out.println("6���˳�");
System.out.println("7��ע���˻�");
System.out.println("��������������");
4.��ѯ�˻���Ϣ
System.out.println("==================����ǰ�˻�������Ϣ����======================");
System.out.println("���ţ�" + acc.getCardId());
System.out.println("������" + acc.getUserName());
System.out.println("��" + acc.getMoney());
System.out.println("����ȡ�ֶ�ȣ�" + acc.getQuotaMoney());
5.���
System.out.println("==================��ӭ�����˻�������======================");
System.out.println("�����������");
double money = sc.nextDouble();
acc.setMoney(acc.getMoney() + money);
showAccount(acc);
6.ȡ��
System.out.println("==================��ӭ�����˻�ȡ�����======================");