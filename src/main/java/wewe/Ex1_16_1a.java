
package wewe;
import frame.Ex1_16_1b;
import frame.Ex1_16_1c;

public class Ex1_16_1a {
	public static void main (String[] args) {
		
		int totalListPrice = 0 ;                             //�w���������i�̍��v���z�i�艿�j
		
		//�R�}���h���C����������w���������i�̍��v���z�i�艿�j���擾
		for(int i = 0 ; i < args.length ; i++ ){
			totalListPrice += Integer.parseInt( args[i] );
		}
		
		//Ex1_16_1b�N���X�i�O���̃p�b�P�[�W�j���C���X�^���X���i�C���X�^���X���FinstanceExB�j
		Ex1_16_1b instanceExB = new Ex1_16_1b() ;
		//Ex1_16_1b�N���X��calcTaxPrice���\�b�h���g���čw���������i�̍��v���z�i�ō��j���擾
		int totalTaxPrice = instanceExB.calcTaxPrice( totalListPrice );  //�w���������i�̍��v���z�i�ō��j
		
		//Ex1_16_1c�N���X�i�O���̃p�b�P�[�W�j���C���X�^���X���i�C���X�^���X���FinstanceExC�j
		Ex1_16_1c instanceExC = new Ex1_16_1c();
		//Ex1_16_1c�N���X��discount���\�b�h���g���Ċ�����̎x�����z���擾
		int payPrice = instanceExC.discount( totalTaxPrice );            //������̎x�����z
		
		//������̎x�����z��\��
		System.out.println("������̎x�����z�F" + payPrice + "�~" );

	}
}
