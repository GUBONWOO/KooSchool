package frame;

public class Ex1_16_1b {
	
	public int calcTaxPrice( int price ){        //�A���_�[�o�[��K�؂ȓ��e�ɏ��������Ă�������
		
		final double TAX = 1.08 ;                //����Łi8%�j
		
		return (int)( price * TAX ) ;
		
	}
	
}
