package frame;
public class Ex1_16_1c {
	
	public int discount( int price ){
		
		final int    DISCOUNT_BORDER1   = 1000 ;   //�l�������̋��E�l�i1000�~�j
		final int    DISCOUNT_BORDER2   = 5000 ;   //�l�������̋��E�l�i5000�~�j
		final double DISCOUNT_RATE1     = 0.1  ;   //�l�����i1000�~�ȏ�5000�����j
		final double DISCOUNT_RATE2     = 0.2  ;   //�l�����i5000�~�ȏ�j
		final int    DISCOUNT_PRICE_MAX = 5000 ;   //�l�����z�̏��
		
		int priceDown = 0 ;                        //�l���z
		
		//<�l���z�ipriceDown�j�̌v�Z>
		// - �����Ƃ��Ď󂯎�����l��1000�ȏ�ꍇ5000�����������ꍇ�A1000�𒴂������ɂ���10�������ɂ���
		// - �����Ƃ��Ď󂯎�����l��5000���傫���ꍇ�A1000�~�ȏ�5000�����̕��ɂ���10��OFF�A5000�~�ȏ�̕��ɂ���20�������ɂ���
		if ( DISCOUNT_BORDER1 <= price && price < DISCOUNT_BORDER2 ){
			
			priceDown = (int)( (price - DISCOUNT_BORDER1) * DISCOUNT_RATE1 ) ;
			
		}else if ( DISCOUNT_BORDER2 < price ){
			
			priceDown = (int)(   (DISCOUNT_BORDER2 - DISCOUNT_BORDER1) * DISCOUNT_RATE1 
			                   + (     price       - DISCOUNT_BORDER2) * DISCOUNT_RATE2   ) ;
			
		}
		
		//����z�i5000�~�j�𒴂��Ă���ꍇ�A�������z������z�ōĐݒ肷��
		if( DISCOUNT_PRICE_MAX < priceDown ){
			priceDown = DISCOUNT_PRICE_MAX ;
		}
		
		//�����K����̋��z��Ԃ�
		return price - priceDown ;
		
	}	
}
