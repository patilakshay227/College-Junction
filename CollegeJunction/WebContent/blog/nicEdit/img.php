<?php
	if(isset($_FILES['image'])){
		$img = $_FILES['image'];
		$path = "images/".rand().$img["name"];
		move_uploaded_file($img['tmp_name'],$path);
		$data = getimagesize($path);
		$link = "http://localhost:8080/CollegeJunction/blog/nicEdit/".$path;
		
		$res = array(
			"data" => array(
				"links" => $link,
				"width" => $data[0],
				"height" => $data[1]
			));
		if(!function_exists('json_encode')){
			function json_encode($res){
				require_once 'JSON.php';
				$json = new Services_JSON;
				return $json->encode($res);
			}
		}
		
		echo json_encode($res);
	}

?>