package less04.strategy.work.impl;

import less04.strategy.model.HumanInfo;
import less04.strategy.model.Resources;
import less04.strategy.model.Worker;
import less04.strategy.work.Work;

public enum WorkPlace {
	
	FOOD{
		public Work place(Worker worker, Resources resources){
			HumanInfo.getInstance().setFoodCollectors(HumanInfo.getInstance().getFoodCollectors()+1);
			return new CollectFood(worker, resources);
		}
		public void decrementWorker(){
			HumanInfo.getInstance().setFoodCollectors(HumanInfo.getInstance().getFoodCollectors()-1);
		}
	},
	WOOD{
		public Work place(Worker worker, Resources resources){
			HumanInfo.getInstance().setWoodCollectors(HumanInfo.getInstance().getWoodCollectors()+1);
			return new CollectWood(worker, resources);
		}
		public void decrementWorker(){
			HumanInfo.getInstance().setWoodCollectors(HumanInfo.getInstance().getWoodCollectors()-1);
		}
	},
	STONE{
		public Work place(Worker worker, Resources resources){
			HumanInfo.getInstance().setStoneCollectors(HumanInfo.getInstance().getStoneCollectors()+1);
			return new CollectStone(worker, resources);
		}
		public void decrementWorker(){
			HumanInfo.getInstance().setStoneCollectors(HumanInfo.getInstance().getStoneCollectors()-1);
		}
	},
	IRON{
		public Work place(Worker worker, Resources resources){
			HumanInfo.getInstance().setIronCollectors(HumanInfo.getInstance().getIronCollectors()+1);
			return new CollectIron(worker, resources);
		}
		public void decrementWorker(){
			HumanInfo.getInstance().setIronCollectors(HumanInfo.getInstance().getIronCollectors()-1);
		}
	};
	public abstract Work place(Worker worker, Resources resources);

	public abstract void decrementWorker();
}
