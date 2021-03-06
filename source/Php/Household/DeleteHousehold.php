<?php
include_once $_SERVER ['DOCUMENT_ROOT'] . '/Household/Common/AbstractController.php';
include_once $_SERVER ['DOCUMENT_ROOT'] . '/Household/Dao/HshldDao.php';
include_once $_SERVER ['DOCUMENT_ROOT'] . '/Household/Dao/HshldLogDao.php';
include_once $_SERVER ['DOCUMENT_ROOT'] . '/Household/Entity/Hshld.php';
class DeleteHousehold extends AbstractController {
	private $hshldDao;
	private $hshldLogDao;
	private $idx;
	private $gid;
	protected function initialize() {
		$this->hshldDao = new HshldDao ();
		$this->hshldLogDao = new HshldLogDao ();
	}
	protected function validate() {
		$this->idx = parent::getParam ( "IDX" );
		$this->gid = parent::getParam ( "GID" );
		return true;
	}
	protected function main() {
		$item = $this->hshldDao->find ( $this->idx, $this->gid );
		$this->hshldLogDao->insert ( $item );
		$this->hshldDao->delete ( $this->idx, $this->gid );
		return $item->toArray ();
	}
	protected function error($e) {
		parent::setHeaderError ( 406, "" );
	}
}
$obj = new DeleteHousehold ();
$obj->run ();
?>