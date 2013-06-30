package com.geae.event
{
	import flash.events.Event;
	
	public class GeaeEvent extends Event{
		
		public static const VALID_NOUVEAU_DOSSIER:String="VALID_NOUVEAU_DOSSIER";
		
		public function GeaeEvent(type:String, bubbles:Boolean=false, cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
		}
		
		public static function valideNouveauDossier():GeaeEvent{
			var event:GeaeEvent= new GeaeEvent(VALID_NOUVEAU_DOSSIER);
		}
	}
}