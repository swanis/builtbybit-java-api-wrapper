# List of requests
HealthRequest (String)

## Alerts
ListUnreadAlertsRequest(SortOptions sortOptions) (Alert[])  
MarkUnreadAlertsAsReadRequest(boolean read) (Void)

## Conversations
ListUnreadConversationsRequest(SortOptions sortOptions) (Conversation[])  
StartConversationRequest(int[] recipientIds, String title, String message) (Integer)

## Conversation Replies
ListUnreadConversationRepliesRequest(int conversationId, SortOptions sortOptions) (Reply[])  
ReplyToUnreadConversationRequest(int conversationId, String message) (Integer)

## Members
ListBansRequest (Ban[])  
ModifyYourselfRequest(String customTitle, String aboutMe, String signature) (Void)  
RetrieveMemberByIDRequest(int memberId) (Member)  
RetrieveMemberByUsernameRequest(String username) (Member)  
RetrieveYourselfRequest (Member)

## Profile Posts
DeleteProfilePostRequest(int profilePostId) (Void)  
EditProfilePostRequest(int profilePostId, String message) (Void)  
ListProfilePostsRequest(SortOptions sortOptions) (ProfilePost[])  
RetrieveSpecificProfilePostRequest(int profilePostId) (ProfilePost)

## Resources
ListOwnedResourcesRequest(SortOptions sortOptions) (BasicResource[])  
ListPublicResourcesRequest(SortOptions sortOptions) (BasicResource[])  
ListCollaboratedResourcesRequest(SortOptions sortOptions) (BasicResource[])  
ModifyResourceRequest(int resourceId, String title, String tag_line, String description) (Void)  
RetrieveResourceRequest(int resourceId) (Resource)

## Resource Downloads
ListResourceDownloadsByMemberRequest(int resourceId, int memberId, SortOptions sortOptions) (Download[])  
ListResourceDownloadsByVersionRequest(int resourceId, int versionId, SortOptions sortOptions) (Download[])  
ListResourceDownloadsRequest(int resourceId, SortOptions sortOptions) (Download[])

## Resource Licenses
IssueResourceLicenseRequest(int resourceId, boolean permanent, boolean active, int purchaserId, long startDate, long endDate) (Integer)  
ListResourceLicensesRequest(int resourceId, SortOptions sortOptions) (License[])  
ModifyResourceLicenseRequest(int resourceId, int licenseId, boolean permanent, boolean active, long startDate, long endDate) (Void)  
RetrieveResourceLicenseRequest(int resourceId, int licenseId) (License)  
RetrieveResourceLicenseByMemberRequest(int resourceId, int memberId, int nonce, long timestamp) (License)

## Resource Purchases
ListResourcePurchasesRequest(int resourceId, SortOptions sortOptions) (Purchase[])  
RetrieveResourcePurchaseRequest(int resourceId, int purchaseId) (Purchase)

## Resource Reviews
ListResourceReviewsRequest(int resourceId, SortOptions sortOptions) (Review[])  
RespondToResourceReviewRequest(int resourceId, int reviewId, String message) (Void)  
RetrieveMemberResourceReviewRequest(int resourceId, int memberId) (Review)

## Resource Updates
ListResourceUpdatesRequest(int resourceId, SortOptions sortOptions) (Update[])  
RetrieveLatestResourceUpdateRequest(int resourceId) (Update)  
RetrieveResourceUpdateRequest(int resourceId, int updateId) (Update)

## Resource Versions
ListResourceVersionsRequest(int resourceId, SortOptions sortOptions) (Version[])  
RetrieveLatestResourceVersionRequest(int resourceId) (Version)  
RetrieveResourceVersionRequest(int resourceId, int versionId) (Version)

## Threads
FetchThreadRequest(int threadId) (Thread)  
ListThreadsRequest(SortOptions sortOptions) (BasicThread[])

## Thread Replies
ListThreadRepliesRequest(int threadId, SortOptions sortOptions) (Reply[])  
ReplyToThreadRequest(int threadId, String message) (Integer)
