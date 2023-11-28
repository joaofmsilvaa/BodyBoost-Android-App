<?php

namespace App\Services;


use MailchimpMarketing\ApiClient;

class MailchimpNewsletter
{

    public function subscribe(string $email, string $list = null){

        $list ??= config('services.mailchimp.lists.subscribed');

        return $this->client()->lists->addListMember($list, [
            'email_address' => $email,
            'status' => 'subscribed'
        ]);
    }


    public function client(){
        $client = (new ApiClient)->setConfig([
            'apiKey' => config('services.mailchimp.key'),
            'server' => 'us21'
        ]);

        return $client;
    }

}
